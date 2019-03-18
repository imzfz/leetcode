import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zfz on 2019/3/18.
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        ListNode first = head;
        boolean[] contains = new boolean[10000];
//        Set<Integer> list = Arrays.stream(G).boxed().collect(Collectors.toSet());
        int flag = 0, count = 0;

        if(head == null){
            return 0;
        }

        for(int i = 0; i < G.length; i++){
            contains[G[i]] = true;
        }

        while (first != null){
            if(contains[first.val]){
                flag = 1;
                first = first.next;
            }
            else {
                if(flag == 1){
                    count++;
                }
                flag = 0;
                first = first.next;
            }
        }

        if(flag == 1){
            count++;
        }
        return count;
    }
}
