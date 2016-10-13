/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//dfs
public class Solution {
	boolean foundp = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode left = inorderSuccessor(root.left, p);
        if (left != null) return left;
        if (foundp) return root;
        if (root == p) foundp = true;
        TreeNode right = inorderSuccessor(root.right, p);
        if (right != null) return right;   
        return null;    
    }
}