package hot100.linkedlist;

public class deleteLastN19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode left = fakeHead;
        ListNode right = head;


        for (int i = 0; i < n-1; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return fakeHead.next;
    }
}
