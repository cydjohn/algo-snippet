/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
        	ListNode p1 = p.next;
        	p.next = p1.next;
        	p1.next = p.next.next;
        	p.next.next = p1;
        	p = p.next.next;
        }
        return dummy.next;
    }
}