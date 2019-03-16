/**
 * Created by zfz on 2019/3/16.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = head;
        ListNode cur = head;
        ListNode second = null;
        ListNode next = head;
        int count = 0;

        if(head == null){
            return null;
        }

        second = first.next;
        if(second == null || k <= 1){
            return head;
        }

        if(second.next == null){
            return reverse(head, 2);
        }

        second = null;
        while (true) {
            for (int i = 0; i < k; i++) {
                next = next.next;
                if (i <= k - 2) {
                    cur = next;
                }
                if (next == null) {
                    return head;
                }
            }

            cur.next = null;
            first = reverse(first, k);
            if (count == 0) {
                head = first;
                count++;
            }
            else {
                second.next = first;
            }
            while (first.next != null) {
                first = first.next;
            }
            second = first;
            first.next = next;
            first = next;
            second.next = first;
        }
//        return head;
    }

    public ListNode reverse(ListNode l, int k){
        ListNode first = l;
        ListNode second = first.next;
        ListNode next = second.next;

        while (next != null || k == 2){
            if(k == 2){
                second.next = first;
                first.next = null;
                break;
            }

            if(first == l){
                second.next = first;
                first.next = null;
            }

            first = next;
            next = first.next;
            first.next = second;
            second = first;
            first = second.next;

        }
        return second;
    }
}
