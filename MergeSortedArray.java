/**
 * Created by zfz on 2019/2/23.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if(n == 0){
            return;
        }
        for(int i = 0, n1 = 0, n2 = 0; n2 < n; i++){

            if(n1 >= m + n2 || n1 >= nums1.length){
                System.arraycopy(nums2, n2, nums1, m + n2, n - n2);
                return;
            }
            if(n2 >= nums2.length){
                n2--;
            }
            if(nums1[n1] <= nums2[n2]){
                n1++;
            }
            else{
                nums1 = move(nums1, n1, m + n2);
                nums1[n1] = nums2[n2];
                n2++;
            }
        }
    }

    public int[] move(int[] nums1, int start, int end){
        if(end < start)
            return nums1;
        System.arraycopy(nums1, start, nums1, start + 1, end - start);
        return nums1;
    }
}
