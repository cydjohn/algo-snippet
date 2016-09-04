/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/discuss/100429/java-iterative-and-recursive-solutions
//iteratively
//repeatedly put the larger item in the next item.
//60%
/*1) Create an empty sorted (or result) list
2) Traverse the given list, do following for every node.
......a) Insert current node in sorted way in sorted or result list.*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), p1 = head;
        while (p1 != null) { //travel the list with p1
            ListNode p2 = dummy; //find the suitable insertion position with p2
            while (p2.next != null && p2.next.val <= p1.val) p2 = p2.next;
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p1.next;
            p2.next.next = temp;
        }
        return dummy.next;
    }
}

//97%
//improvement: add adjcencent comparison to skip the insertion process while the order is maintained
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p, dummy = new ListNode(0), node = head;
        dummy.next = head;
        while (node.next != null) { //travel the list with node.next
            if (node.val > node.next.val) { //skip the insertion process while the order is maintained
                p = dummy; //find the suitable insertion position with p for node.next
                while (p.next != null && p.next.val < node.next.val) {
                    p = p.next;
                }
                ListNode next2 = node.next.next;
                node.next.next = p.next; //be careful! node.next.next != node
                p.next = node.next;
                node.next = next2;
            }
            else node = node.next;
        }
        return dummy.next;
    }
}


//recursively
//73%
public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode p = insertionSortList(head.next);
    	if (head.val <= p.val) {
    		head.next = p;
    		return head;
    	}
    	ListNode ret = p;
    	while (p.next != null && p.next.val < head.val) {
    		p = p.next;
    	} 
    	head.next = p.next;
    	p.next = head;
    	return ret;
    }
}