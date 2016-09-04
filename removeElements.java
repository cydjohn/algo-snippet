/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//with dummy node
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
        	if (p.next.val == val) p.next = p.next.next;
        	else p = p.next;
        }
        return dummy.next;
    }
}

//without dummy node
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) head = head.next;
        ListNode p = head;
        while (p != null && p.next != null) {
        	if (p.next.val == val) {
        		p.next = p.next.next;
        	}else {
        		p = p.next;
        	}
        }
        return head;
    }
}

