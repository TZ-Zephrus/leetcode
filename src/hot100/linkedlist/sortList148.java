package hot100.linkedlist;

import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-26
 */
public class sortList148 {

    // 先来个冒泡 正确 但会超时
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        ListNode suf = null;
        ListNode first = dummyHead;
        ListNode count = head;
        int len = 0;
        while (count != null) {
            len++;
            count = count.next;
        }
        for (int i = 0; i < len-1; i++) {
            pre = dummyHead;
            curr = dummyHead.next;
            for (int j = 0; j < len-1-i; j++) {
                // 判断大小后交换节点
                if (curr.val > curr.next.val) {
                    // 交换
                    suf = curr.next.next;
                    pre.next = curr.next;
                    pre.next.next = curr;
                    curr.next = suf;
                }
                // 重新赋值
                pre = pre.next;
                curr = pre.next;
            }
        }
        return dummyHead.next;
    }

    // 归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode listNode = guiBing(head);
        return listNode;
    }
    public ListNode guiBing(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode h1 = guiBing(head);
        ListNode h2 = guiBing(head2);
        ListNode h = new ListNode();
        ListNode curr = h;
        while (true) {
            if (h1 == null) {
                curr.next = h2;
                break;
            }
            if (h2 == null) {
                curr.next = h1;
                break;
            }
            if (h1.val > h2.val) {
                curr.next = h2;
                h2 = h2.next;
                curr = curr.next;
            } else {
                curr.next = h1;
                h1 = h1.next;
                curr = curr.next;
            }
        }
        return h.next;
    }

    // 快速排序
    public ListNode sortList3(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode listNode = kuaiSu(head);
        return listNode;
    }
    public ListNode kuaiSu(ListNode head) {
        if (head.next == null) {
            return head;
        }
        // 把比head大的放到big链表，小的放到small链表
        ListNode smallHead = new ListNode();
        ListNode small = smallHead;
        ListNode bigHead = new ListNode();
        ListNode big = bigHead;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < head.val) {
                small.next = curr;
                curr = curr.next;
                small = small.next;
                small.next = null;
            } else {
                big.next = curr;
                curr = curr.next;
                big = big.next;
                big.next = null;
            }
        }
        // 对新生成的大小链表分别进行排序
        ListNode headNew = new ListNode();
        if (smallHead.next != null) {
            ListNode smallHeadNew = kuaiSu(smallHead.next);
            ListNode temp = smallHeadNew;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            headNew = smallHeadNew;
        } else {
            headNew = head;
        }
        if (bigHead.next != null) {
            ListNode bigHeadNew = kuaiSu(bigHead.next);
            head.next = bigHeadNew;
        } else {
            head.next = null;
        }
        return headNew;
    }
}
