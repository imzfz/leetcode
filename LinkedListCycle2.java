import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zfz on 2019/1/28.
 */
public class LinkedListCycle2 {
    //用set判断重复节点
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;

        if(head == null){
            return null;
        }

        while(cur  != null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }

    //快慢指针
    public ListNode detectCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int count = -1;

        if(head == null || head.next == null){
            return null;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == slow){
            ListNode temp = head;
            while(temp != slow){
                temp = temp.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
}
