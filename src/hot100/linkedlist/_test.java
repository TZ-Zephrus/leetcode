package hot100.linkedlist;


public class _test {
    public static void main(String[] args) {
        MyLRUCache myLRUCache = new MyLRUCache(2);
        myLRUCache.put(1,1);
        myLRUCache.put(2,2);
        myLRUCache.get(1);
        myLRUCache.put(3,3);
        myLRUCache.get(2);
        myLRUCache.put(4,4);
        myLRUCache.get(1);
        myLRUCache.get(3);
        myLRUCache.get(4);
    }
}