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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
        	public int compare(ListNode a, ListNode b) {
        		return a.val - b.val;
        	}
        });
        int emptyList = 0;
        for (ListNode i : lists) {
            if (i == null) emptyList++;
        	else pq.add(i);
        }
        if (emptyList == lists.length) return null;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (!pq.isEmpty()) {
        	p.next = pq.poll();
        	p = p.next;
        	if (p.next != null) pq.add(p.next);
        }
        return res.next;
    }
}