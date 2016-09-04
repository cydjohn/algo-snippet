/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode hi = head, lo = head, p = head;
        while (hi != null && hi.val < x) hi = hi.next;
        while (lo != null && lo.val >= x) lo = lo.next;
        ListNode startLo = lo, startHi = hi;
        while (p != null) {
        	if (p.val < x && p != startLo) {
        		lo.next = p;
        		lo = lo.next;
        	}
        	else if (p.val >= x && p != startHi) {
        		hi.next = p;
        		hi = hi.next;
        	}
        	p = p.next;
        }
        if (hi != null) hi.next = null;
        if (lo != null) {
        	lo.next = startHi;
        	return startLo;
        }else {
        	return startHi;
        }
        
    }
}