package hot100.linkedlist;

public class cycleListTWO142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode one = head;
        ListNode two = slow;
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
