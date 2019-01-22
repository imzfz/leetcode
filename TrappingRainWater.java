public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = 1, begin = 0, end = height.length - 1;
        int res = 0;

        //两端去0
        for (int i = begin, j = end, flag1 = 0, flag2 = 0; i <= j && (flag1 == 0 || flag2 == 0); i++, j--) {
            if (height[i] == 0 && flag1 == 0) {
                begin++;
            } else if (i + 1 < height.length && height[i + 1] > height[i] && flag1 == 0) {
                begin++;
            } else {
                flag1 = 1;
            }

            if (height[j] == 0 && flag2 == 0) {
                end--;
            }
            else if (j - 1 >= 0 && height[j - 1] > height[j] && flag2 == 0) {
                end--;
            }
            else {
                flag2 = 1;
            }
            System.out.println(begin + " " + end);
        }

        left = begin;
        right = left + 1;

        while (right <= end) {

            if (height[right] < height[left]) {
                //有比right更高的就继续，没有就结算
                if(right == end || !hasBiggerThan(right, height)){
                    res = res - (height[left] - height[right]) * (right - left - 1);
                    left = right;
                }
                else {
                    res = res + (height[left] - height[right]);
                }
                right++;
            }

            //right高于left
            else if (height[right] >= height[left]) {
//                res = res - (height[right] - height[left]) * (right - left + 1);
                left = right;
                right++;
            }
        }

        return res;
    }

    public boolean hasBiggerThan(int begin, int[] height){
        for(int i = height.length - 1; i > begin; i--){
            if(height[i] > height[begin]){
                return true;
            }
        }
        return false;
    }
}
