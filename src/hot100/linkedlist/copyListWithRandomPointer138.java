package hot100.linkedlist;

import java.util.HashMap;

public class copyListWithRandomPointer138 {
    public RandomNode copyRandomList(RandomNode head) {
        HashMap<RandomNode, RandomNode> hashMap = new HashMap<>();
        RandomNode node = head;
        while (node != null) {
            RandomNode newNode = new RandomNode(node.val);
            hashMap.put(node, newNode);
            node = node.next;
        }
        node = head;
        RandomNode dummyHead = new RandomNode(0);
        RandomNode curr = hashMap.get(node);
        dummyHead.next = curr;
        while (node != null) {
            curr.next = hashMap.get(node.next);
            curr.random = hashMap.get(node.random);
            node = node.next;
            curr = curr.next;
        }
        return dummyHead.next;
    }

    // 递归方法
    HashMap<RandomNode, RandomNode> hashMap = new HashMap<>();
    public RandomNode copyRandomList2(RandomNode head) {
        if (head == null) {
            return null;
        }
        if (!hashMap.containsKey(head)) {
            RandomNode newHead = new RandomNode(head.val);
            hashMap.put(head, newHead);
            head.next = copyRandomList2(head.next);
            head.random = copyRandomList2(head.random);
        }
        return hashMap.get(head);
    }
}
