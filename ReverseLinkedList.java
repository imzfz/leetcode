public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode nextOne = head;
        ListNode nextTwo = head;

        if(head == null){
            return null;
        }

        if(head.next != null){
            nextOne = head.next;
        }
        else {
            return head;
        }
        if(nextOne.next != null){
            nextTwo = nextOne.next;
        }
        else {
            nextOne.next = head;
            head.next = null;
            return nextOne;
        }

        while (nextTwo != null){
            nextOne.next = head;
            if(head.next == nextOne){
                head.next = null;
            }
            head = nextOne;
            nextOne = nextTwo;
            nextTwo = nextTwo.next;
        }
        nextOne.next = head;
        head = nextOne;

        return head;
    }
}
