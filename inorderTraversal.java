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
	List<Integer> ans = new ArrayList();
	public List<Integer> inorderTraversal(TreeNode root) {
		dfs(root);
		return ans;
	}
	private void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		ans.add(root.val);
		dfs(root.right);
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
    		/*stop condition: nothing to add and pop*/
    		if (stack.isEmpty()) break;

    		TreeNode node = stack.pop();
    		ans.add(node.val);
    		root = node.right;
    	}
    	return ans;
    }
}