/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        /*use dummy node to avoid corner case [0], in which the left child could not be visited without dummy*/
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = head, tail = dummy;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	tail = slow; /*tail is the last node of left child*/
        	slow = slow.next; /*slow is the root, i.e. the mid node, after loop*/
        }
        TreeNode root = new TreeNode(slow.val);
        tail.next = null; /*saparate the list and get the left list out*/
        root.left = sortedListToBST(dummy.next);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}