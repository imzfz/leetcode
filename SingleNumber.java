import java.util.Arrays;

/**
 * Created by zfz on 2019/2/24.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2){
            if((nums[i] ^ nums[i - 1]) != 0){
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }
}
