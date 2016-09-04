/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode slow = head, fast = head;
        int size = size(head);
        int rotate = k % size;
        if (rotate == 0) return head;
        for (int i = 0; i < rotate; i++) {
        	fast = fast.next;
        }
        while (fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        fast.next = head;
        return ret;
    }
    private int size(ListNode head) {
    	ListNode p = head;
    	int size = 0;
    	while (p != null) {
    		size++;
    		p = p.next;
    	}
    	return size;
    }
}