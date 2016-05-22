/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// The constraint is generally applied recursively to every subtree. That is, the tree is only balanced if:
// The left and right subtrees' heights differ by at most one, AND
// The left subtree is balanced, AND
// The right subtree is balanced

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = height(root.left) - height(root.right);
        if ( diff > 1 || diff < -1) return false; //or use abs() here
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    private int height(TreeNode root) {
    	if (root == null) return -1;
    	int l = height(root.left);
    	int r = height(root.right);
    	return 1 + ( l > r ? l : r); //avoid to use max()
    } 
}