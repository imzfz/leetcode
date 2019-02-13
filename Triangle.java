import java.util.List;

/**
 * Created by zfz on 2019/2/13.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size1 = triangle.size(), size2;
        Integer dp[][] = new Integer[size1][];
        dp[0] = new Integer[1];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < size1; i++){
            size2 = triangle.get(i).size();
            dp[i] = triangle.get(i).toArray(new Integer[size2]);
            for(int j = 0; j < size2; j++) {
                if(j == 0) {
//                    dp[i][j] += triangle.get(i - 1).get(j);
                    dp[i][j] += dp[i-1][j];
                }
                else if(j == size2 - 1){
//                    dp[i][j] += triangle.get(i - 1).get(j - 1);
                    dp[i][j] += dp[i-1][j-1];
                }
                else {
//                    dp[i][j] += Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j]);
                }

            }
        }

        int res = Integer.MAX_VALUE;
        for(int temp : dp[triangle.size() - 1]){
            res = temp < res ? temp : res;
        }
        return res;
    }
}
