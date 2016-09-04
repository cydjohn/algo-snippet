//Q: what if the starting ppoint of the reverse is the head of the list?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0); //important!
        ListNode pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m-1; i++) 
        	pre = pre.next;
        ListNode cur = pre.next, p = pre.next;
        ListNode prev = null, next = null;
        for (int i = 0; i <= n-m; i++) {
        	next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        p.next = cur;
        pre.next = prev;
        return dummy.next;
    }
}