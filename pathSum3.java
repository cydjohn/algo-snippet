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
	int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        inPathSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return cnt;
    }
    private void inPathSum(TreeNode root, int sum) {
    	if (root == null) return;
        if (sum == root.val) cnt++;
        inPathSum(root.left, sum - root.val);
        inPathSum(root.right, sum - root.val);
    }
}