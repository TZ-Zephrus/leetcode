package linkedlist;

public class shejilianbiao707 {
    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);    // 链表变为 1->2->3
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        myLinkedList.get(4);              // 返回 2
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);    // 现在，链表变为 1->3
//        myLinkedList.addAtHead(6);
//        System.out.println(myLinkedList.first);


/*        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        [    [],            [1],         [3],         [1,2],   [1],   [0],          [0]]*/
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        myLinkedList.get(1);
//        myLinkedList.deleteAtIndex(0);
//        myLinkedList.get(0);
//        System.out.println(myLinkedList.first);


//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//            [[],            [1],         [3],        [1,2],    [1],       [1],      [1]]
/*        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        System.out.println(myLinkedList.first);*/


/*        ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
                   [[],        [0,10],     [0,20],      [1,30],    [0]]*/
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);
        myLinkedList.get(0);
        System.out.println(myLinkedList.first);
    }


/*        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
                 [[],      [7],        [2],         [1],        [3,0],         [2],          [6] ,        [4],    [4],    [4],         [5,0],       [6]]
*/

     static class MyLinkedList {
        ListNode first = new ListNode();
        int length;
        public MyLinkedList() {
            first.val = 0;
            first.next = null;
        }



        public int get(int index) {
            int i = 0;
            ListNode midnode = first;
            while (midnode != null){
                if (i == index+1){
                    return midnode.val;
                }
                midnode = midnode.next;
                i++;
            }
            return -1;
        }

         //在链表最前面插入一个节点，等价于在第0个元素前添加
         public void addAtHead(int val) {
             addAtIndex(0, val);
         }

         //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
         public void addAtTail(int val) {
             addAtIndex(length, val);
         }

        public void addAtIndex(int index, int val) {
            if (index > length) {
                return;
            }
            //先找到要插入顶点的前一个顶点
            ListNode midnode = first;
            for (int i = 0; i < index; i++) {
                midnode = midnode.next;
            }
            ListNode newnode = new ListNode();
            newnode.val = val;
            newnode.next = midnode.next;
            midnode.next = newnode;
            length++;
        }




        public void deleteAtIndex(int index) {
            if (index >= length){
                return;
            }
            if (index == 0) {
                first = first.next;
                return;
            }
            ListNode midnode = first;
            for (int i = 0; i < index+1 -1; i++) {
                midnode = midnode.next;
            }
            midnode.next = midnode.next.next;
            length--;
        }


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
