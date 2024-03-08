package hot100.linkedlist;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-28
 */
class DLinkedNode {
    public int key;
    public int val;
    public DLinkedNode before;
    public DLinkedNode after;
    public DLinkedNode() {};
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + after +
                '}';
    }
}