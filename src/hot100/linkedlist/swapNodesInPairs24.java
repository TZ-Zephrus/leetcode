package hot100.linkedlist;

public class swapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode curr = new ListNode();
        ListNode temp = new ListNode();
        ListNode end = new ListNode();
        curr = head;
        while (curr != null && curr.next != null) {
            end = curr.next.next;
            temp = curr;
            curr = curr.next;
            first.next = curr;
            curr.next = temp;
            temp.next = end;
            first = first.next.next;
            curr = curr.next.next;
        }
        return dummyHead.next;
    }
}
