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

//cleaner version
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode x = stack.pop();
            ans.add(x.val);
            if (x.right != null) stack.push(x.right);
            if (x.left != null) stack.push(x.left);
        }
        return ans;
    }
}