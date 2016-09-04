/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*Trap: left subtree nodes must all be less than root val, so we need to keep root val to check this condition while going deeper with dfs.*/
public class Solution {
    public boolean isValidBST(TreeNode root) {
    	return isBST(root, null, null);
    }

    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
    	if (root == null) return true;
    	if (min != null && min.val >= root.val) return false;
    	if (max != null && max.val <= root.val) return false;
    	return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}