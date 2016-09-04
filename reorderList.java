/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        //get the middle point of list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode p2 = reverse(slow.next);
        slow.next = null;
        //merge two lists
        ListNode p1 = head.next, p = head;
        while (p1 != null || p2 != null) {
        	if (p2 != null) {
        		p.next = p2;
        		p = p.next;
        		p2 = p2.next;
        	}
        	if (p1 != null) {
        		p.next = p1;
        		p = p.next;
        		p1 = p1.next;
        	}
        }
    }
    private ListNode reverse(ListNode head) {
    	if (head == null) return null;
    	ListNode prev = null;
    	ListNode cur = head;
    	ListNode next = null;
    	while (cur != null) {
    		next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
}