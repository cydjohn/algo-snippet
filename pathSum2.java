/*You are given a binary tree (not necessarily BST) in which each node contains a value. Design an algorithm to print all paths which sum up to that value. Note that it can be any path in the tree - it does not have to start at the root.*/
public class Solution {
	List<List<Integer>> res = new ArrayList();
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		if (root == null) return res;
		dfs(root, sum, 0, new ArrayList<Integer>());
		return res;
	}
	private void dfs(TreeNode root, int sum, int cur, List<Integer> list) {
		if (root == null) return;
		int newSum = cur + root.val;
		list.add(root.val);
		if (newSum == sum) res.add(new ArrayList<Integer>(list));
		dfs(root.left, sum, newSum, list);
		dfs(root.right, sum, newSum, list);
		dfs(root.left, sum, newSum, new ArrayList<Integer>());
		dfs(root.right, sum, newSum, new ArrayList<Integer>());
	}
}