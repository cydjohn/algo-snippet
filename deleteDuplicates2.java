/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy; boolean du = false;
        while (p.next != null && p.next.next != null) {
        	if (p.next.val == p.next.next.val) {
        		p.next.next = p.next.next.next;
        		du = true;
        	}
        	else {
        		if (du) {
        		    p.next = p.next.next;
        		    du = false;
        		}
        		else p = p.next;
        	}
        }
        if (du) p.next = p.next.next;//importatnt!
        return dummy.next;
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}