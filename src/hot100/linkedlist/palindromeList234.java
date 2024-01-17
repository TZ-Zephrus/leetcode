package hot100.linkedlist;

public class palindromeList234 {
    public boolean isPalindrome(ListNode head) {
        //preIndex用来记录连接后半部分的
        ListNode preIndex = null;
        ListNode index = head;
        if (index == null) {
            return true;
        }
        int len = 0;
        while (index != null) {
            len++;
            index = index.next;
        }
        index = head;
        for (int i = 0; i < (len+1)/2; i++) {
            preIndex = index;
            index = index.next;
        }
        preIndex.next = reverList(index);
        index = head;
        for (int i = 0; i < (len+1)/2; i++) {
            index = index.next;
        }
        ListNode indexNew = head;
        while (index != null) {
            if (indexNew.val != index.val) {
                //这里出结果了，在返回前把链表再反转回去
                index = head;
                for (int i = 0; i < (len+1)/2; i++) {
                    preIndex = index;
                    index = index.next;
                }
                preIndex.next = reverList(index);
                return false;
            }
            indexNew = indexNew.next;
            index = index.next;
        }
        //这里出结果了，在返回前把链表再反转回去
        index = head;
        for (int i = 0; i < (len+1)/2; i++) {
            preIndex = index;
            index = index.next;
        }
        preIndex.next = reverList(index);
        return true;
    }

    public ListNode reverList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
