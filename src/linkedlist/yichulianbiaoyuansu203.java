package linkedlist;


/*给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


        示例 1：


        输入：head = [1,2,6,3,4,5,6], val = 6
        输出：[1,2,3,4,5]
        示例 2：

        输入：head = [], val = 1
        输出：[]
        示例 3：

        输入：head = [7,7,7,7], val = 7
        输出：[]
        */

public class yichulianbiaoyuansu203 {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(removeElements(node0, 6));

    }


    //写太复杂了
    public static ListNode removeElements(ListNode head, int val) {
        //先判断head是不是val
        while (head != null && head.val == val){
            head = head.next;
        }
        //先创建节当前点的对象,用于遍历整个链表
        ListNode midnode = head;
        OUT: while (midnode != null && midnode.next != null){
            //创建一个暂时点，用于找是否有连续与val的点
            ListNode tempnode = midnode;
            while (true){
                //不等时，令midnode和tempnode连上
                if (tempnode.next.val != val){
                    midnode.next = tempnode.next;
                    break;
                } else {
                    //相等时，再找下一个点
                    if (tempnode.next != null) {
                        tempnode = tempnode.next;
                        if (tempnode.next == null){
                            midnode.next = null;
                            break OUT;
                        }
                    }
                }
            }
            //更新midnode
            midnode = midnode.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
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
