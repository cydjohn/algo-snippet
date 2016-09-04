/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Initiate a sentinel node to avoid nullpointer exception caused by p.next or p.next.next
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        int length = 0;
        //calculate the length of the list
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length ++;
        }
        //get the exact node to remove from the front
        int removePos =  length - n + 1;
        //delet the node by resetting the pointers
        p = sentinel;
        while (removePos - 1 > 0) {
            p = p.next;
            removePos --;
        }
        p.next = p.next.next;
        return sentinel.next;
        }

}