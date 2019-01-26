public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode con = res;
        int sum = 0;
        int flag = 0;

        if(l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null){
            return new ListNode(0);
        }
        else if(l1.val == 0 && l1.next == null){
            return l2;
        }
        else if(l2.val == 0 && l2.next == null){
            return l1;
        }

        while(l1 != null && l2 != null){
            con.next = new ListNode(-1);
            con = con.next;
            sum = l1.val + l2.val + flag;
            flag = 0;
            if(sum / 10 == 1){
                flag = 1;
                con.val = sum % 10;
            }
            else {
                con.val = sum;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            con.next = new ListNode(-1);
            con = con.next;
            sum = l1.val + flag;
            flag = 0;
            if(sum / 10 == 1){
                flag = 1;
                con.val = sum % 10;
            }
            else {
                con.val = sum;
            }
            l1 = l1.next;
        }

        while(l2 != null){
            con.next = new ListNode(-1);
            con = con.next;
            sum = l2.val + flag;
            flag = 0;
            if(sum / 10 == 1){
                flag = 1;
                con.val = sum % 10;
            }
            else {
                con.val = sum;
            }
            l2 = l2.next;
        }

        if(flag != 0){
            con.next = new ListNode(1);
        }

        return res.next;
    }
}
