/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//dfs参数传递累加
public class Solution {
	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root, false);
        return sum;
    }
    private void dfs(TreeNode root, boolean onLeft) {
    	if (root == null) return;
    	if (onLeft && root.left == null && root.right == null) sum += root.val;
    	dfs(root.left, true);
    	dfs(root.right, false);
    }
}