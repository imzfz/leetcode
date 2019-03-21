/**
 * Created by zfz on 2019/3/21.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[grid.length - 1].length == 0){
            return 0;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                    continue;
                }
                if(j == 0 && i != 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                    continue;
                }
                if(i == 0 && j == 0)    continue;
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
