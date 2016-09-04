/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null) return head;   
    	ListNode slow = head, fast = head.next.next;
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	} 
    	ListNode p2 = sortList(slow.next);
    	slow.next = null;
    	ListNode p1 = sortList(head);
    	return merge(p1, p2);
    }
    private ListNode merge(ListNode p1, ListNode p2) {
    	//dummy免除了需要看比较条件来新建List的麻烦过程
    	ListNode p, dummy = new ListNode(0);
    	p = dummy;
    	while (p1 != null && p2 != null) {
    		if (p1.val < p2.val) {
    			p.next = p1;
    			p1 = p1.next;
    		}
    		else {
    			p.next = p2;
    			p2 = p2.next;
    		}
    		p = p.next;
    	}
    	p.next = (p1 == null) ? p2 : p1;
    	return dummy.next;
    }
}