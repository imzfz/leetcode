/**
 * Created by zfz on 2019/1/30.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        res = lists[0];

        for(int i = 1; i < lists.length; ++i){
            res = mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
