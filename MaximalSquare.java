/**
 * Created by zfz on 2019/2/11.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int length = 0, res = 0;

        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                while (i + length < matrix.length && j + length < matrix[i+length].length &&
                        isSquare(j, i, j + length, i + length, matrix)){
                    length++;
                }
                res = length > res ? length : res;
                length = 0;
            }
        }
        return res * res;
    }

    public boolean isSquare(int x, int y, int p, int q, char[][] matrix){
        for(int i = y; i < q + 1; ++i){
            for(int j = x; j < p + 1; ++j){
                if(matrix[i][j] != '1')
                    return false;
            }
        }
        return true;
    }

    //// dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
    public int maximalSquareDP(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int res = 0;
        // 初始化dp数组
        for(int i = 0; i < r; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            res = dp[i][0] > res ? dp[i][0] : res;
        }

        for(int i = 0; i < c; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            res = dp[0][i] > res ? dp[0][i] : res;
        }

        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
                    res = dp[i][j] > res ? dp[i][j] : res;
                }
            }
        }
        return res * res;
    }

    public int min(int a, int b, int c) {
        if(a <= b && a <= c)return a;
        if(b <= a && b <= c)return b;
        return c;
    }
}
