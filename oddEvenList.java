/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
    	if (head == null) return null;
    	ListNode odd = head, even = head.next, evenHead = even;
        //even在前面，只要保证even非null，则odd一定有解。
    	while (even != null && even.next != null) {
    		odd.next = odd.next.next;
    		even.next = even.next.next;
    		even = even.next;
    		odd = odd.next;
    	}
    	odd.next = evenHead;
    	return head;
    }
}