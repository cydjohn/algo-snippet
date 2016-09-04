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
    boolean ok = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ok;
    }
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) ok = true;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}