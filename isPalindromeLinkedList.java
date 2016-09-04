/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//if we want O(n) time and O(1) space, consider two pointers or rearrange the input, in this problem, two pointers is not suitable for listnode.
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode start = head, fast = head;
        while (fast.next != null && fast.next.next != null) { //maybe there only one elements, or start has reached the last item, thus .next should be in front of .next.next 
        	start = start.next;
        	fast = fast.next.next;
        }
        ListNode p1 = head;
        ListNode p2 = start.next;
        p2 = reverse(p2);//reverse the 2th half of the list

        while (p1 != null && p2 != null) {
        	if (p1.val != p2.val) return false;
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return true;
    }
    private ListNode reverse(ListNode s) {
    	if (s == null) return null;
    	ListNode prev = null, next = null;
    	ListNode cur = s;
    	while (cur != null) {
    		next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
}