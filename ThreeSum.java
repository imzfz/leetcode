import java.util.*;

/**
 * Created by zfz on 2019/2/22.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int line = bs(nums);

        if(line == -1){
            return new ArrayList<>();
        }

        if(line + 1 < nums.length && line + 2 < nums.length
                && nums[line] == 0 && nums[line + 1] == 0 && nums[line + 2] == 0){
            list.add(Arrays.asList(nums[line], nums[line + 1], nums[line + 2]));
        }

        for(int i = 0; i < line + 1; i++){
            for(int j = line; j < nums.length; j++){
                int twoSum = nums[i] + nums[j];
                List<Integer> addList;
                if(twoSum > 0){
                    int three = find(nums, -twoSum, 0, line + 1);
                    if(three != -1 && i != j && i != three && j != three){
                        addList = Arrays.asList(nums[i], nums[j], nums[three]);
                        Collections.sort(addList);
                        list.add(addList);
                    }

                }
                else if(twoSum == 0){
                    if(i != line && nums[line + 1] == 0){
                        addList = Arrays.asList(nums[i], nums[j], nums[line + 1]);
                        Collections.sort(addList);
                        list.add(addList);
                    }
                }
                else {
                    int three = find(nums, -twoSum, line, nums.length - 1);

                    if(three != -1 && i != j && i != three && j != three){
                        addList = Arrays.asList(nums[i], nums[j], nums[three]);
                        Collections.sort(addList);
                        list.add(addList);
                    }
                }
            }
        }
        list.sort((o1, o2) -> {
            if(o1.get(0).compareTo(o2.get(0)) == 0){
                if(o1.get(1).compareTo(o2.get(1)) == 0){
                    if(o1.get(2).compareTo(o2.get(2)) == 0){
                        return 0;
                    }
                    else {
                        return o1.get(2).compareTo(o2.get(2));
                    }
                }
                else {
                    return o1.get(1).compareTo(o2.get(1));
                }
            }
            return o1.get(0).compareTo(o2.get(0));
        });
        list = isDuplicate(list);
        return list;
    }

    public List<List<Integer>> isDuplicate(List<List<Integer>> list){
        list.sort(Comparator.comparing(o -> o.get(0)));
        Iterator<List<Integer>> iterator = list.iterator();
        int i = 0;
        int a = 0, b = 0, c = 0;

        for(; iterator.hasNext(); ){
            List<Integer> next = iterator.next();
            if (i == 0) {
                a = next.get(0);
                b = next.get(1);
                c = next.get(2);
                i++;
                continue;
            }
            else{
                if(!(a == next.get(0) && b == next.get(1) && c == next.get(2))){
                    a = next.get(0);
                    b = next.get(1);
                    c = next.get(2);
                    continue;
                }
            }

            if(a == next.get(0) && (b == next.get(1) && c == next.get(2) || b == next.get(2) && c == next.get(1))){
                iterator.remove();
            }
            else {
                i = 0;
            }
            i++;
        }
        return list;
    }

    public int bs(int[] nums){
        int start = 0, end = nums.length - 1;
        int middle = (start + end) / 2;

        while (start <= end){
            middle = (start + end) >> 1;
            if(nums[middle] >= 0){
                if(middle == 0 || (middle - 1 >= 0 && nums[middle - 1] < 0)){
                    return middle;
                }
                end = middle - 1;
            }
            else {
                if(middle + 1 < nums.length && nums[middle + 1] >= 0){
                    return middle + 1;
                }
                start = middle + 1;
            }
        }
        return -1;
    }

    public int find(int[] nums, int target, int start, int end){
//        int start = 0, end = nums.length - 1;
        int middle = (start + end) / 2;

        while (start <= end){
            middle = (start + end) >> 1;
            if(nums[middle] == target){
                return middle;
            }
            else if(nums[middle] > target){
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
