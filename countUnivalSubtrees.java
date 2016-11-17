/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*这里我们先创建一个Global变量count， 也可以不用global变量而使用一个size为数组作为参数传递进辅助函数isUnival中。
isUnival主要就是递归地自底向上判断tree是否为unival,也就是所有节点值均相等。有下面几种情况需要考虑
root = null,这时候我们返回true。递归终止时，每个leaf节点都为true，所以null情况我们返回true
当左子树为unival并且右子树也为unival的时候
假如左右子节点都为空，则我们遇到leaf节点，合理，count++
假如左子节点或者右子节点不为空，但值又不与root的值相等时，root本身加左右子树形成的这个subtree不满足题意，我们返回false
否则，root及其descendants形成一个满足题意的subtree，我们把count++，记录下这个subtree
要注意判断左右子树是否为unival的时候，左子树和右子树都要判断，这里我们使用了一个'&'符号来避免短路条件判断。也可以分开写。*/
public class Solution {
	int cnt = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return cnt;
    }
    private boolean dfs(TreeNode root) {
    	if (root == null) return true;
    	if (dfs(root.left) & dfs(root.right)) {
    		if (root.left != null && root.left.val != root.val) return false;
    		if (root.right != null && root.right.val != root.val) return false;
    		cnt++;
    		return true;
    	}
    	return false;
    }
}