/**
 * Created by zfz on 2019/2/20.
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
}
