public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}