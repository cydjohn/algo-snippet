/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//用int和string的运算代替dynamic list
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        num += root.val;
        if (root.left == null && root.right == null) sum += num;
        dfs(root.left, num*10);
        dfs(root.right, num*10);
    }
}

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

