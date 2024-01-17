package hot100.linkedlist;

public class cycleList141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow != null) {
                slow = slow.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            if (slow != null && fast != null && slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
