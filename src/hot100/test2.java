package hot100;


import java.util.Arrays;

import hot100.double_pointer.*;
import hot100.slide_window.*;
import hot100.sub_string.*;
import hot100.matrix.*;
import hot100.linkedlist.*;
/**
 * @author WangTianze
 * @description
 * @date 2024-02-27
 */
public class test2 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node11.next = node12;
        node12.next = node13;
        node21.next = node22;
        node22.next = node23;
        node31.next = node32;
        ListNode[] listNodes = new ListNode[] {node11, node21, node31};
        mergeKSortedList23 mergeKSortedList23 = new mergeKSortedList23();
        ListNode listNode = mergeKSortedList23.mergeKLists(listNodes);
        System.out.println(listNode);

    }
}
