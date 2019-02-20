/**
 * Created by zfz on 2019/2/20.
 * 这道题好像有官方题解
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int dp[][] = new int[s.length()][s.length()];
        int length = 0, start = 0, end = 0;

        if(s.length() == 0){
            return "";
        }

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j) &&
                        (i - j < 2 || (j + 1 < s.length() && dp[j + 1][i - 1] == 1))){
                    dp[j][i] = 1;
                }
                if(dp[j][i] == 1 && length < i - j + 1){
                    length = i - j + 1;
                    start = j;
                    end = i;
                }
            }
            dp[i][i] = 1;
        }
        return s.substring(start, end + 1);
    }

    //马拉车算法
    public String longestPalindrome(String s, int unused){
        StringBuilder t =new StringBuilder("$#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append("#");
        }
        int p[] = new int[t.length()], id = 0, mx = 0, resId = 0, resMx = 0;
        for (int i = 1; i < t.length(); ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < t.length() && t.charAt(i + p[i]) == t.charAt(i - p[i])) ++p[i];
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resMx < p[i]) {
                resMx = p[i];
                resId = i;
            }
        }
        return s.substring((resId - resMx) / 2, (resId - resMx) / 2 + resMx - 1);
    }
}
