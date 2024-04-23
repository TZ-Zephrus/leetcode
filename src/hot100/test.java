package hot100;

import java.util.Arrays;

import hot100.double_pointer.*;
import hot100.slide_window.*;
import hot100.sub_string.*;
import hot100.matrix.*;
import hot100.linkedlist.*;
public class test {
    public static void main(String[] args) {
//        sortList148 sortList148 = new sortList148();
//        ListNode node11 = new ListNode(11);
//        ListNode node12 = new ListNode(22);
//        ListNode node13 = new ListNode(13);
//        ListNode node14 = new ListNode(34);
////        ListNode node15 = new ListNode(15);
////        ListNode node16 = new ListNode(9);
////        ListNode node17 = new ListNode(9);
//        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;
////        node14.next = node15;
////        node15.next = node16;
////        node16.next = node17;
////        ListNode node21 = new ListNode(9);
////        ListNode node22 = new ListNode(9);
////        ListNode node23 = new ListNode(9);
////        ListNode node24 = new ListNode(9);
////        node21.next = node22;
////        node22.next = node23;
////        node23.next = node24;
//        ListNode node = sortList148.sortList3(node11);
//        System.out.println(node);
        int[][] arr = new int[2][2];
        arr[0][0] = 2;
        arr[0][1] = 3;
        arr[1][0] = 3;
        arr[1][1] = 3;
        Arrays.sort(arr, (o1, o2) -> o2[0]-o1[0]);
        System.out.println(arr[0][0]);
        System.out.println(arr[1][0]);
    }
}