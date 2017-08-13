/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) pq.offer(l);
        }
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (cur.next != null) pq.offer(cur.next);
            p.next = cur;
            p = p.next;
        }
        return res.next;
    }
}
