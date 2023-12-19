package linkedlist;


//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//
//        图示两个链表在节点 c1 开始相交：
//
//
//
//        题目数据 保证 整个链式结构中不存在环。

public class xiangjiaolianbiao160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        //找出A和B的长度
        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }
        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        //移动较长链表的指针
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                currB = currB.next;
            }
        }
        while (currA != null && currB != null) {
            if (currA == currB) {
                break;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
