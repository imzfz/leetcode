/**
 * Created by zfz on 2019/1/27.
 * 思路类似的其他人的解法
 */
public class SortListOthers {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        ListNode tmp = head;

        while (tmp.next != null)
            tmp = tmp.next;

        return partition(head, tmp);
    }

    private ListNode partition(ListNode start, ListNode end) {
        if (start == end) {
            start.next = null;
            return start;
        }

        ListNode slow = start;
        ListNode fast = slow;

        while (!(fast == end || fast.next == end)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        ListNode node1 = partition(start, slow);
        ListNode node2 = partition(next, end);

        if (node1.val > node2.val) {
            ListNode tmp = node1;
            node1 = node2;
            node2 = tmp;
        }

        ListNode head = node1;
        ListNode tmp = head;
        node1 = node1.next;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                tmp.next = node2;
                tmp = node2;
                node2 = node2.next;
            }
            else {
                tmp.next = node1;
                tmp = node1;
                node1 = node1.next;
            }
        }

        tmp.next = node1 == null ? node2 : node1;
        return head;
    }
}
