package hot100.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-28
 */
public class LRUcache146 {

    // 用LinkedHashMap实现
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        public int get(int key) {
            Integer result = this.getOrDefault(key, -1);
            return result;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            if (this.size() > capacity) {
                return true;
            }
            return false;
        }
    }

    // 自己用双向链表实现
    class LRUCache2 {
        private int capacity;
        private int size;
//        private DLinkedNode head;
//        private DLinkedNode tail;
        final private DLinkedNode dummyHead = new DLinkedNode();
        final private DLinkedNode dummyTail = new DLinkedNode();
        final private HashMap<Integer, DLinkedNode> hashMap;
        public LRUCache2(int capacity) {
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
                dLinkedNode.val = value;
                hashMap.put(key, dLinkedNode);
                moveToHead(dLinkedNode);
                size++;
                if (size > capacity) {
                    removeTail(key);
                }
            }
        }

        private void removeTail(int key) {
            DLinkedNode lastNode = dummyTail.before;
            hashMap.remove(key);
            lastNode.before.after = dummyTail;
            dummyTail.before = lastNode.before;
            lastNode.before = null;
            lastNode.after = null;
            size--;
        }


        private void moveToHead(DLinkedNode dLinkedNode) {
            dLinkedNode.after = dummyHead.after;
            dummyHead.after.before = dLinkedNode;
            dLinkedNode.before = dummyHead;
            dummyHead.after = dLinkedNode;
        }
    }
}
