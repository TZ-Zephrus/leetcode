package hot100;

import java.util.Arrays;

import hot100.double_pointer.*;
import hot100.slide_window.*;
import hot100.sub_string.*;
import hot100.matrix.*;
import hot100.linkedlist.*;
public class test {
    public static void main(String[] args) {
        twoNumSum2 twoNumSum2 = new twoNumSum2();
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        ListNode node = twoNumSum2.addTwoNumbers(node11, node21);
        System.out.println(node);
    }
}