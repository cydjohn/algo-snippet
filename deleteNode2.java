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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) return deleteNode(root.right, key);
        else if (key < root.val) return deleteNode(root.left, key);
        else {
        	if (root.left == null) return root.right;
        	if (root.right == null) return root.left;
        	else {
        		root.val = getMin(root.right);
        		deleteNode(root.right, root.val);
        	}
        }
        return root;
    }
    private int getMin(TreeNode root) {
    	if (root == null) return 0;
    	while (root.left != null) {
    		root = root.left;
    	}
    	return root.val;
    }
}