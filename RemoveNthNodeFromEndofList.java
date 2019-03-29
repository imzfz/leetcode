/**
 * Created by zfz on 2019/3/29.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int count = 0;

        for (int i = 0; i < n && first != null; i++) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }

        first = first.next;

        while (first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }
}
