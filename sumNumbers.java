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
	private List<Integer> path = new ArrayList();
	private int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
    	if (root == null) return;
    	path.add(root.val);
    	if (root.left == null && root.right == null) {
    		for (int i = path.size()-1, k = 1; i >= 0; i--, k = k*10) {
    			ans += path.get(i)*k;
    		}
    	}
    	dfs(root.left);
    	dfs(root.right);
    	path.remove(path.size()-1);
    }
}