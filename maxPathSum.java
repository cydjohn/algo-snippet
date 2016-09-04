/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Trap: node val might be negative.*/
public class Solution {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    /*
    (1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
    (2) returns the maximum sum of the path that can be extended to input node's parent.
    */
    private int maxPath(TreeNode root) {
    	if (root == null) return 0;
    	/*if the path sum is negative, don't use negative part.*/
    	int l = Math.max(0, maxPath(root.left));
    	int r = Math.max(0, maxPath(root.right));
    	max = Math.max(max, l + r + root.val);
    	return Math.max(l, r) + root.val;
    }
}