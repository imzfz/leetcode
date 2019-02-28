import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zfz on 2019/2/28.
 */
public class AllPathsFromSourcetoTarget {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(0);
            dfs(graph, graph[0][i], item, res);
        }
        return res;
    }

    public void dfs(int[][] graph, int from, List<Integer> item, List<List<Integer>> res) {
        item.add(from);
        if (graph[from].length == 0 && from == graph.length - 1) {
            res.add(item);
            return;
        }

        for (int j = 0; j < graph[from].length; j++) {
            dfs(graph, graph[from][j], new ArrayList<>(item), res);
        }
    }
}
