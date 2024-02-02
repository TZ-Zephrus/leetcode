package hot100.linkedlist;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-01
 */
public class twoNumSum2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode first = node;
        int remainder = 0;
        while (true) {
            if (l1 == null && l2 != null) {
                int number = (l2.val + remainder) % 10;
                node.next = new ListNode(number);
                remainder = (l2.val + remainder) / 10;
                l2 = l2.next;
                node = node.next;
            } else if (l2 == null && l1 != null) {
                int number = (l1.val + remainder) % 10;
                node.next = new ListNode(number);
                remainder = (l1.val + remainder) / 10;
                l1 = l1.next;
                node = node.next;
            } else if (l1 == null && l2 == null) {
                if (remainder != 0) {
                    node.next = new ListNode(remainder);
                }
                break;
            } else {
                int number = (l1.val + l2.val + remainder) % 10;
                node.next = new ListNode(number);
                remainder = (l1.val + l2.val + remainder) / 10;
                l1 = l1.next;
                l2 = l2.next;
                node = node.next;
            }
        }
        return first.next;
    }
}
