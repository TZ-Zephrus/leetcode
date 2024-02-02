package hot100.linkedlist;

public class reverseNodesInKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int times = len/k;
        // 需要一个虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = new ListNode();
        for (int i = 0; i < times; i++) {
            ListNode newHead = left.next;
            right = newHead;
            for (int j = 0; j < k; j++) {
                right = right.next;
            }
            left.next = reverseList(newHead, k);
            // 反转后newHead成为了子链表的尾节点
            newHead.next = right;
            left = newHead;
        }
        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head, int k) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 返回反转后子链表的头节点，尾节点就是head
        return pre;
    }
}
