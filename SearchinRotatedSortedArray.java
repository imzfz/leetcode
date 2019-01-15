public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int rotate = find(0, nums.length - 1, nums);

        if (rotate - 1 < 0 && nums.length == 1) {
            if (target == nums[rotate])
                return 0;
            else return -1;
        }

        if (target < nums[rotate] || rotate - 1 >= 0 && target > nums[rotate - 1]) {
            return -1;
        } else if (target >= nums[rotate] && target <= nums[nums.length - 1]) {
            return bs(rotate, nums.length - 1, nums, target);
        } else if (rotate - 1 >= 0 && target >= nums[0] && target <= nums[rotate - 1]) {
            return bs(0, rotate - 1, nums, target);
        }

        return -1;
    }

    //二分
    public int bs(int begin, int end, int[] nums, int target) {
        int middle = 0;
        while (begin <= end) {
            middle = (begin + end) >> 1;
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                begin = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //找旋转点
    public int find(int begin, int end, int[] nums) {
        int middle = 0;

        if(nums[begin] < nums[end]){
            return 0;
        }

        while (begin <= end) {
            middle = (begin + end) >> 1;

            if (nums[middle] > nums[begin]) {
                begin = middle + 1;
                if (begin < nums.length && nums[begin] < nums[middle]) {
                    return begin;
                }
            } else if (nums[middle] < nums[begin]) {
                end = middle - 1;
                if (end >= 0 && nums[end] > nums[middle]) {
                    return middle;
                }
            } else {
                if(middle + 1 < nums.length && nums[middle + 1] < nums[begin])
                    return middle + 1;
                else if(middle + 1 < nums.length && nums[middle + 1] > nums[begin])
                    return begin;
                else
                    return 0;
            }
        }

        return middle;
    }
}
