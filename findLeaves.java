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
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        while (root.val != Integer.MIN_VALUE) {
        	List<Integer> list = new ArrayList();
        	dfs(root, list);
        	res.add(list);
        }
        return res;
    }
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
    	if (root.left == null && root.right == null) {
    		list.add(root.val);
    		root.val = Integer.MIN_VALUE;//root = null无法成立，只能将null赋给root.left和root.right
    	    return;
    	}
    	dfs(root.left, list);
    	dfs(root.right, list);
    	if (root.left != null && root.left.val == Integer.MIN_VALUE) root.left = null;
    	if (root.right != null && root.right.val == Integer.MIN_VALUE) root.right = null;
    }
}

//pitfall: root = null不能使用？