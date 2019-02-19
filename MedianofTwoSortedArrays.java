/**
 * Created by zfz on 2019/2/19.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先判断是否有一组是空的
        if(nums1.length == 0){
            if(nums2.length % 2 == 0){
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1] ) / 2.0;
            }
            else {
                return nums2[nums2.length / 2];
            }
        }
        else if(nums2.length == 0){
            if(nums1.length % 2 == 0){
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1] ) / 2.0;
            }
            else {
                return nums1[nums1.length / 2];
            }
        }

        int total = nums1.length + nums2.length;
        int end = 0;
        int i, j, k;
        int flag = 0;
        //flag用于判断是否有一组已经到末尾
        //end用于指示当前按大小顺序遍历的数字

        for (i = 0, j = 0, k = 0; i < total / 2; i++) {
            //循环一半的次数
            //判断是否有一个已经到末尾
            if (j == nums1.length) {
                end = nums2[k];
                k++;
                flag = 2;
                continue;
            }
            if (k == nums2.length) {
                end = nums1[j];
                j++;
                flag = 1;
                continue;
            }

            //更新end的指示
            if (nums1[j] > nums2[k]) {
                end = nums2[k];
                k++;
            }
            else if (nums1[j] <= nums2[k]) {
                end = nums1[j];
                j++;
            }
        }

        //复查一次是否有最后一次到末尾的
        if(j == nums1.length){
            j--;
            flag = 2;
        }
        if(k == nums2.length){
            k--;
            flag = 1;
        }

        if(total % 2 == 0) {
            if(flag == 1){
                return (nums1[j] + end) / 2.0;
            }
            else if(flag == 2) {
                return  (nums2[k] + end) / 2.0;
            }
            else {
                if (nums1[j] > nums2[k]) {
                    return (nums2[k] + end) / 2.0;
                }
                else {
                    return (nums1[j] + end) / 2.0;
                }
            }
        }
        else {
            if(flag == 1){
                return nums1[j];
            }
            else if(flag == 2) {
                return nums2[k];
            }
            else {
                if (nums1[j] > nums2[k]) {
                    end = nums2[k];
                }
                else {
                    end = nums1[j];
                }
            }
        }
        return end;
    }
}
