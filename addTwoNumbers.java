/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null || l2 != null) {
        	p.next = new ListNode(0);
        	p = p.next;
        	if (l1 != null) {
        		c += l1.val;
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		c += l2.val;
        		l2 = l2.next;
        	}
        	if (c > 9) {
        		p.val = c - 10;
        		c = 1;
        	}
        	else {
        		p.val = c;
        		c = 0;
        	}
        }
        if (c == 1) p.next = new ListNode(1);
        return res.next; 
    }
}

