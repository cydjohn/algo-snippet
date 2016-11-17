/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    //必须使用dummy node，不能直接返回cur，cur在最后是指向root的，因为这是最外层的，然而我们需要返回以最左边节点为开始的list
    DoublyListNode dummy = new DoublyListNode(0);
    DoublyListNode pre = dummy;
    //inorder traversal: connect prev node with current node every time
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        bstToDoublyList(root.left);
        DoublyListNode cur = new DoublyListNode(root.val);
        pre.next = cur;
        if (pre != p) cur.prev = pre;
        pre = cur;
        bstToDoublyList(root.right);
        return dummy.next;
    }
}
