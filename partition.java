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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.val < x) {
        	p = p.next;
        }
        ListNode p1 = p;
        while (p1.next != null) {
        	if (p1.next.val < x) {
        		ListNode p2 = p.next;
        		p.next = p1.next;
        		p1.next = p1.next.next;
        		p = p.next;
        		p.next = p2;
        	}else {
        		p1 = p1.next;
        	}
        }
        return dummy.next;
    }
}