/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*如对于数组1,2,7,4,5,6,3,8,9，如何判断是哪两个元素发生了交换呢？

不难发现，新的数组中存在两对逆序并相邻的数字，即7,4和6,3，造成这出现的原因，正是发生了一次交换，由于一定是较小的数换到了较大数的位置（向后），较大的数换到了较小数的位置（向前）。所以在这两对中，我们可以简单的判断出：是前一对的较大数和后一对的较小数发生了交换。*/
public class Solution {
	TreeNode first, second;
	TreeNode last = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    public void dfs(TreeNode root) {
    	if (root == null) return;
    	dfs(root.left);
    	if (first == null && root.val < last.val) first = last;
    	if (first != null && root.val < last.val) second = root;
    	last = root;
    	dfs(root.right);
    }
}


//Wrong Answer 2-3-1 有两对数，没法确定那个数进行了交换
public class Solution {
	TreeNode w1, w2;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        if (!dfs(root, null, null)) return;
        int tmp = w1.val;
        w1.val = w2.val;
        w2.val = tmp;
    }
    private boolean dfs(TreeNode root, TreeNode max, TreeNode min) {
    	if (root == null) return false;
    	if ((max != null && root.val > max.val) || (min != null && root.val < min.val)) {
    		if (w1 == null) w1 = root;
    		else {
    			w2 = root;
    			return true;
    		}
    	}
    	if (dfs(root.left, root, min)) return true;
    	if (dfs(root.right, max, root)) return true;
    	return false;
    }
}