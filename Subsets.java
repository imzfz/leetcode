import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2019/3/3.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            find(nums, i, res, new ArrayList<>());
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void find(int[] nums, int i, List<List<Integer>> res, List<Integer> item) {
        if (i >= nums.length) {
            return;
        }
        item.add(nums[i]);
        for(int j = 1; j < nums.length - i; j++){
            find(nums, i + j, res, new ArrayList<>(item));
        }
        res.add(item);

    }
}
