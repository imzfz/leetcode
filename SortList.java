/**
 * 不太会写归并排序。好像时间有点长，但是也过了。
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = findMiddle(head);

        head1 = merge_sort(head1);
        head2 = merge_sort(head2);

        return merge(head1, head2);
    }


    public ListNode findMiddle(ListNode head){
        ListNode quick = head;
        ListNode slow = head;
        int count = 0;

        while(quick != null){
            if(count == 2){
                slow = slow.next;
                count = 0;
            }
            count++;
            quick = quick.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;

        return slow;
    }

    public ListNode merge_sort(ListNode l1){
        if(l1.next == null){
            return l1;
        }
        else {
            l1 = merge(merge_sort(findMiddle(l1)), merge_sort(l1));
        }

        /*if(l1 != null && l1.next != null && l1.val > l1.next.val){
            l1.next.next = l1;
            l1.next = null;
        }*/

        return l1;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode point = res;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = new ListNode(l2.val);
                point = point.next;
                l2 = l2.next;
            }
            else if(l1.val < l2.val){
                point.next = new ListNode(l1.val);
                point = point.next;
                l1 = l1.next;
            }
            else {
                point.next = new ListNode(l1.val);
                l1 = l1.next;
                point = point.next;
                point.next = new ListNode(l2.val);
                point = point.next;
                l2 = l2.next;
            }
        }

        if(l1 != null){
            point.next = l1;
        }

        if(l2 != null){
            point.next = l2;
        }
        return res.next;
    }
}
