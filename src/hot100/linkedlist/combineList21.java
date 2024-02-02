package hot100.linkedlist;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-01
 */
public class combineList21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode result = node;
        while (true) {
            if (list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null) {
                node.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
                node = node.next;
            } else {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
                node = node.next;
            }
        }
        return result.next;
    }

    // 递归写法
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
}
