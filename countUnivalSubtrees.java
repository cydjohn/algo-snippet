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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
        	return 1 + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        }
        return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }
}