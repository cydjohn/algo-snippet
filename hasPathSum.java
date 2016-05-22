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
	private int temp = 0;
	private boolean found = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        pathSum(root, sum, temp);
        return found;
    }

    private void pathSum(TreeNode root, int sum, int temp) {
    	if (root == null) return;
    	temp += root.val;
    	if (root.left == null && root.right == null && temp == sum) found = true;
    	pathSum(root.left, sum, temp);
    	pathSum(root.right, sum, temp); 
    }
}