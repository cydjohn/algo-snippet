/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*题目中的Follow up让我们用O(n)的时间复杂度来解决问题，我们还是采用DFS的思想来解题，由于时间复杂度的限制，只允许我们遍历一次整个二叉树，由于满足题目要求的 二叉搜索子树必定是有叶节点的，所以我们的思路就是先递归到最左子节点，然后逐层往上递归，对于每一个节点，我们都记录当前最大的BST的节点数，当做为左子树的最大值，和做为右子树的最小值，当每次遇到左子节点不存在或者当前节点值大于左子树的最大值，且右子树不存在或者当前节点值小于右子树的最小数时，说明BST的节点数又增加了一个，我们更新结果及其参数，如果当前节点不是BST的节点，那么我们更新BST的节点数res为左右子节点的各自的BST的节点数的较大值*/
public class Solution {
	int res = 0;
	class Range {
		boolean bst;
		int min, max;
		int cnt = 1;
		public Range(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    private Range dfs(TreeNode root) {
    	if (root == null) return null;
    	Range range = new Range(root.val, root.val);
    	Range left = dfs(root.left);
    	Range right = dfs(root.right);
    	if (left != null) {
    		if (!left.bst || left.max >= root.val) return range;
    		range.min = left.min;
    		range.cnt += left.cnt;
    	}
    	if (right != null) {
    		if (!right.bst || right.min <= root.val) return range;
    		range.max = right.max;
    		range.cnt += right.cnt;
    	}
    	range.bst = true;
    	res = Math.max(res, range.cnt);
    	return range;
    }
}