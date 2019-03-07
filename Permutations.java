import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2019/3/7.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new boolean[nums.length], res);

        return res;
    }

    public void dfs(List<Integer> list, int[] nums, boolean[] visited, List<List<Integer>> res){
        if(list.size() >= nums.length){
            res.add(list);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(new ArrayList<>(list), nums, visited, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
