/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
        	next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        return prev; //don't return cur, cur is null
    }
}