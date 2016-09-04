/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, tail = head, newHead;
        int cnt = k - 1;
        while (cnt > 0) {
        	if (tail.next != null) {
        		newHead = tail.next;
        		tail.next = newHead.next;
        		newHead.next = p.next;
        		p.next = newHead;
        		cnt--;
        	} else {
        		p.next = reverseKGroup(p.next, k-cnt);
        		break;
        	}
        	if (cnt == 0) {
        		if (tail.next == null) break;
        		p = tail;//翻转后的tail是tail.next的前一个
        		tail = tail.next;
        		cnt = k - 1;
        	}
        }
        return dummy.next;
    }
}