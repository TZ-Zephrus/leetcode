package hot100.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author WangTianze
 * @description
 * @date 2024-02-27
 */
public class mergeKSortedList23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        int index;     // 用于记录读取到的列表当前最小元素的索引。
        int temp;
        while (true) {
            index = -1;
            temp = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val < temp) {
                    index = i;
                    temp = lists[i].val;
                }
            }
            // 为-1说明全是null
            if (index == -1) {
                break;
            }
            curr.next = lists[index];
            lists[index] = lists[index].next;
            curr = curr.next;
        }
        return head.next;
    }


    // 优先级队列版本
    PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> o1.val-o2.val));
    public ListNode mergeKLists4(ListNode[] lists) {
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode s = pq.poll();
            cur.next = s;
            cur=cur.next;
            s = s.next;
            if(s!=null){
                pq.offer(s);
            }
        }
        return dummy.next;
    }
}
