import java.util.Arrays;

/**
 * Created by zfz on 2019/2/18.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return null;
    }
}

//1 4 6 7 9 22 45 75