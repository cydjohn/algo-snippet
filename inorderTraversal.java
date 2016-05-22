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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList();
		dfs(root, ans);
		return ans;
	}

	private void dfs(TreeNode root, List<Integer> ans) {
		if (x == null) return;
		dfs(root.left, ans);
		ans.add(root.val);
		dfs(root.right, ans);
	}
}

//iteratively
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack();
    	List<Integer> ans = new ArrayList();

    	while(true) {
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}

    		if (stack.isEmpty()) break;

    		TreeNode node = stack.pop();
    		ans.add(node.val);
    		root = node.right;
    	}
    	return ans;
    }
}