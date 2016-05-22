/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursively
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList();
		dfs(root, ans);
		return ans;
	}

	private void dfs(TreeNode root, List<Integer> ans) {
		if (root == null) return;
		ans.add(root);
		dfs(root.left, ans);
		dfs(root.right, ans);
	}
}

//interatively
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack();
    	List<Integer> ans = new ArrayList();

    	while(true) {
    		while (root != null) {
    			ans.add(root.val);
    			stack.push(root);
    			root = root.left;
    		}

    		if (stack.isEmpty()) break;

    		TreeNode node = stack.pop();
    		root = node.right;
    	}
    	return ans;
    }
}