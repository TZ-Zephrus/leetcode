package linkedlist;

public class shanchudaoshujiedian19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(removeNthFromEnd(node1, 2));
    }


///nihao
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode curr = dummyhead;
        ListNode suf = dummyhead;
        for (int i = 0; i < n; i++){
            if (suf == null) {
                return head;
            }
            suf = suf.next;
        }
        while (suf.next != null) {
            curr = curr.next;
            suf = suf.next;
        }
        curr.next = curr.next.next;
        return dummyhead.next;
    }


    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
