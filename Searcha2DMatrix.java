/**
 * Created by zfz on 2019/3/20.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;

        if(matrix.length == 0){
            return false;
        }
        for(i = 0; i < matrix.length; i++){
            if(matrix[i].length == 0){
                return false;
            }
            if(matrix[i][0] == target){
                return true;
            }
            if(matrix[i][0] > target) {
                break;
            }
        }

        i--;
        if(i < 0){
            return false;
        }
        for(int j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] == target){
                return true;
            }
        }
        return false;
    }
}
