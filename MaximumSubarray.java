/**
 * Created by zfz on 2019/2/12.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, res = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > currentSum + num){
                currentSum = num;
            }
            else {
                currentSum = currentSum + num;
            }

            if(currentSum > res){
                res = currentSum;
            }
        }
        return res;
    }
}
