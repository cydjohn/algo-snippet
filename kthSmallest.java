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
	private int ans = -1;
	private int ptr = 0;
	private boolean found = false; //a boolean variable helping to stop the recursion method dfs

    public int kthSmallest(TreeNode root, int k) {
    	if (root == null) return -1;
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
    	if (root == null || found == true) return;
    	dfs(root.left, k);
    	ptr = ptr + 1;
    	if (ptr == k) {
    		ans = root.val;
    		found = true;
    	}
    	dfs(root.right, k);
    }
}