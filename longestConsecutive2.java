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
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, 0);
        return max;
    }
    private void dfs(TreeNode root, int parent, int len) {
    	if (root == null) return;
    	if (root.val == parent + 1) {
    		len += 1;
    	} else {
    		len = 1;
    	}
    	if (len > max) max = len;
    	dfs(root.left, root.val, len);
    	dfs(root.right, root.val, len);
    }
}