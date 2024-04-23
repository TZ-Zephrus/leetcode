package hot100.linkedlist;

public class intersectionList160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA;
        ListNode indexB = headB;
        ListNode temp;
        int lenA = 0;
        int lenB = 0;
        int tempLen;
        while (indexA != null) {
            lenA++;
            indexA = indexA.next;
        }
        while (indexB != null) {
            lenB++;
            indexB = indexB.next;
        }
        if (lenA > lenB) {
            temp = headB;
            headB = headA;
            headA = temp;
            tempLen = lenB;
            lenB = lenA;
            lenA = tempLen;
        }
        indexB = headB;
        for (int i = 0; i < lenB-lenA; i++) {
            indexB = indexB.next;
        }
        indexA = headA;
        while (indexA != null) {
            if (indexA == indexB) {
                return indexA;
            }
            indexA = indexA.next;
            indexB = indexB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA != null) {
                pA = pA.next;
            } else {
                pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pA;
    }
}
