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
	//get the height of tree, tree level begin with 1
	private int height(TreeNode root) {
		TreeNode p = root;
        int height = 0;
        while (p != null) {
        	p = p.left;
        	height++; 
        }
        return height;
	}

    public int countNodes(TreeNode root) {
    	if (root == null) return 0;
    	int l = height(root.left);
    	int r = height(root.right);
    	// left side is full
    	if (l == r) return countNodes(root.right) + (1<<l);
    	else return countNodes(root.left) + (1<<r);
    }
}