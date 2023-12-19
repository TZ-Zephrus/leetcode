package linkedlist;

/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



        示例 1：


        输入：head = [1,2,3,4]
        输出：[2,1,4,3]
        示例 2：

        输入：head = []
        输出：[]
        示例 3：

        输入：head = [1]
        输出：[1]*/

public class jiaohuanjiedian24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(swapPairs2(node1));
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0, head);
        ListNode temp = null;
        ListNode pre = dummyhead;
        ListNode suf = null;
        int i = 0; //用于判断循环执行了几次，使更新头节点的语句只执行一次
        while (pre.next != null && pre.next.next != null) {
            //在更新好pre后更新suf
            suf = pre.next.next.next;
            //按照123步骤进行交换
            temp = pre.next.next;
            pre.next.next = suf;
            temp.next = pre.next;
            pre.next = temp;
            //更新pre指针
            pre = temp.next;
            i++;
            //更新头节点
            if (i == 1) {
                head = temp;
            }
        }
        return head;
    }

    //递归法
    public static ListNode swapPairs2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode suf = swapPairs2(head.next.next);
            //开始交换
            ListNode temp = head.next;
            temp.next = head;
            head.next = suf;
            return temp;
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
