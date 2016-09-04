//337. House Robber III
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//深度优先遍历二叉树，每次遍历返回两个值：分别表示偷窃或者不偷窃当前节点可以获得的最大收益。
public class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dfs(TreeNode root) {
    	if (root == null) return new int[2];//with default value 0
    	int[] l = dfs(root.left);
    	int[] r = dfs(root.right);
    	int[] res = new int[2];
    	/*if we don't rob root, root.left and root.right could be robed and not robed*/
    	res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]); 
    	/*if we rob root, root.left and root.right can't be robed*/
    	res[1] = l[0] + r[0] + root.val;
    	return res;
    }
}