import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2019/1/29.
 */
public class IntersectionofTwoLinkedLists {
    //时间太长
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        ListNode t = null;
        int flag = 0;

        while (h1 != null) {
            h2 = headB;
            while (h2 != null) {
                if(h1 == h2 && flag == 0){
                    t = h1;
                    h1 = h1.next;
                    flag = 1;
                }
                else if(h1 == h2){
                    h1 = h1.next;
                }
                h2 = h2.next;
            }
            if(flag == 1){
                return t;
            }
            h1 = h1.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        if(h1 == null || h2 == null){
            return null;
        }

        while(h1 != h2){
            if(h1 == null){
                h1 = headB;
            }
            else {
                h1 = h1.next;
            }

            if(h2 == null){
                h2 = headA;
            }
            else {
                h2 = h2.next;
            }
        }
        return h1;
    }
}
