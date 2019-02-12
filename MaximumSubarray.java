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

    public int maxSubArrayDP(int[] nums) {
        int[] dpArray = new int[nums.length];
        dpArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpArray[i] = Math.max(dpArray[i - 1] + nums[i], nums[i]);
        }
        int sum = dpArray[0];
        for (int i = 1; i < nums.length; i++) {
            if (dpArray[i] > sum) {
                sum = dpArray[i];
            }
        }
        return sum;
    }
}
