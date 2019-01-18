import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
    boolean visited[];
    public int findCircleNum(int[][] M) {
        int count = 0;
        visited = new boolean[M.length];

        for (int i = 0; i < M.length; ++i) {
            if(visited[i]){
                continue;
            }
            isGapFriend(i, M);
            count++;
        }

        return count;
    }

    //dfs
    public boolean isGapFriend(int j, int[][] M) {
        visited[j] = true;
        for(int m = 0; m < M.length; ++m){
            if(M[j][m] == 0 || visited[m]){
                continue;
            }
            isGapFriend(m, M);
        }
        return false;
    }
}
