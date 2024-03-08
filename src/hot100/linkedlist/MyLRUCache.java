package hot100.linkedlist;

import java.util.HashMap;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-28
 */
// 自己用双向链表实现
class MyLRUCache {
    private int capacity;
    private int size;
    private DLinkedNode head;
    //        private DLinkedNode tail;
    private DLinkedNode dummyHead = new DLinkedNode();
    private DLinkedNode dummyTail = new DLinkedNode();
    private HashMap<Integer, DLinkedNode> hashMap;
    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity);
        // 需要虚拟头和虚拟尾，这样不需要每次都判断节点两边是不是null
        dummyHead.after = dummyTail;
        dummyTail.before = dummyHead;
    }


    public int get(int key) {
        DLinkedNode dLinkedNode = hashMap.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        dLinkedNode.before.after = dLinkedNode.after;
        dLinkedNode.after.before = dLinkedNode.before;
        moveToHead(dLinkedNode);
        return dLinkedNode.val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            DLinkedNode dLinkedNode = hashMap.get(key);
            dLinkedNode.val = value;
            dLinkedNode.before.after = dLinkedNode.after;
            dLinkedNode.after.before = dLinkedNode.before;
            hashMap.put(key, dLinkedNode);
            moveToHead(dLinkedNode);
        } else {
            DLinkedNode dLinkedNode = new DLinkedNode();
            dLinkedNode.key = key;
            dLinkedNode.val = value;
            hashMap.put(key, dLinkedNode);
            moveToHead(dLinkedNode);
            size++;
            if (size > capacity) {
                DLinkedNode lastNode = removeTail();
                hashMap.remove(lastNode.key);
            }
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode lastNode = dummyTail.before;
        lastNode.before.after = dummyTail;
        dummyTail.before = lastNode.before;
        lastNode.before = null;
        lastNode.after = null;
        size--;
        return lastNode;
    }


    private void moveToHead(DLinkedNode dLinkedNode) {
        dLinkedNode.after = dummyHead.after;
        dummyHead.after.before = dLinkedNode;
        dLinkedNode.before = dummyHead;
        dummyHead.after = dLinkedNode;
    }
}