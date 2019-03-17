/**
 * Created by zfz on 2019/3/17.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode head1 = head;
        ListNode second = first.next;


        if(second == null || second.next == null){
            return head;
        }

        head1 = second;

        while (first != null && second != null) {
            if(second.next == null){
                first.next = head1;
                break;
            }
            first.next = second.next;
            first = second.next;
            if(first.next == null){
                second.next = null;
                first.next = head1;
                break;
            }
            second.next = first.next;
            second = first.next;
        }
        return head;
    }
}
