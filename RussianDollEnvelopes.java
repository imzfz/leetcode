import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zfz on 2019/2/15.
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        int dp[] = new int[envelopes.length];

        if(envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) return -1;
                else if (o1[1] == o2[1]) return 0;
                else return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            }
            return 1;
        });
        for (int i = 0; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res + 1;
    }
}
