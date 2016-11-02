i/**
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
            //走到最左小，然后回退向上，保证左边孩子先被访问
            //当为null时，表示已经没有左边孩子
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		/*stop condition: nothing to add and pop*/
    		if (stack.isEmpty()) break;

            //pop出一个点，可认为其没有左边孩子或者左边孩子已经被访问
    		TreeNode node = stack.pop();
            //访问中间节点
    		ans.add(node.val);
            //访问右边孩子
    		root = node.right;
    	}
    	return ans;
    }
}