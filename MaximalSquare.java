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
}
