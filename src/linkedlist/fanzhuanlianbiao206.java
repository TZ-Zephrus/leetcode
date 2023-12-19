package linkedlist;

/*给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


        示例 1：


        输入：head = [1,2,3,4,5]
        输出：[5,4,3,2,1]
        示例 2：


        输入：head = [1,2]
        输出：[2,1]
        示例 3：

        输入：head = []
        输出：[]*/

public class fanzhuanlianbiao206 {
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
        System.out.println(reverseList3(node1));
    }


    //常规方法
    public static ListNode reverseList(ListNode head) {
        //先把头head翻转好
        ListNode curr = head.next.next;
        ListNode pre = head.next;
        ListNode temp = null;
        head.next.next = head;
        head.next = null;
        //开始找剩下的
        while (curr != null) {
            temp = curr;
            curr = curr.next;   //每次操作的实际是curr，所以当curr变为null后，就不循环了
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

    //普通方法
    public static ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = null;
        while (curr != null) {
            temp = curr;
            curr = curr.next;   //每次操作的实际是curr，所以当curr变为null后，就不循环了
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

    //递归法
    public static ListNode reverseList3(ListNode head) {
        return reverserecursion(null, head);
    }
    private static ListNode reverserecursion(ListNode pre, ListNode curr) {
        if (curr == null){
            return pre;
        }
//        ListNode temp = curr;
        ListNode first = reverserecursion(curr, curr.next);  //这里的first实际上只是用来记录递归套到最后一层时，找到的新链表头，
        curr.next = pre;                                     //与代码逻辑无关，只是先找到了开头first，然后靠curr.next = pre倒着实现反转
        return first;
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
