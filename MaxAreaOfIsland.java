public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] hasDone = new boolean[50][50];
        int count = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                int newCount = dfs(i, j, hasDone, grid);
                if(newCount > count){
                    count = newCount;
                }
            }
        }
        return count;
    }

    public int dfs(int i, int j, boolean[][] hasDone, int[][] grid){
        int count = 1;
        if(grid[i][j] == 0 || hasDone[i][j]){
            hasDone[i][j] = true;
            return 0;
        }

        if(i + 1 < grid.length && grid[i + 1][j] == 1 && !hasDone[i + 1][j]){
            hasDone[i][j] = true;
            count += dfs(i + 1, j, hasDone, grid);
        }

        if(i - 1 >= 0 && grid[i - 1][j] == 1 && !hasDone[i - 1][j]){
            hasDone[i][j] = true;
            count += dfs(i - 1, j, hasDone, grid);
        }

        if(j + 1 < grid[i].length && grid[i][j + 1] == 1 && !hasDone[i][j + 1]){
            hasDone[i][j] = true;
            count += dfs(i, j + 1, hasDone, grid);
        }

        if(j - 1>= 0 && grid[i][j - 1] == 1 && !hasDone[i][j - 1]){
            hasDone[i][j] = true;
            count += dfs(i, j - 1, hasDone, grid);
        }

        if(grid[i][j] == 1 && !hasDone[i][j] && count == 0){
            hasDone[i][j] = true;
            return 1;
        }
        hasDone[i][j] = true;
        return count;
    }
}
