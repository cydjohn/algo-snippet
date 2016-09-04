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
	//get the ancestor path list of node x, the path list includes node x
	private void path(TreeNode root, TreeNode x, List<TreeNode> ret) {
		if (root == null) return;
		if (root.val == x.val) ret.add(root);
		else if (x.val < root.val) {
			ret.add(root);
			path(root.left, x, ret);
		}
		else {
			ret.add(root);
			path(root.right, x, ret);
		}

	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList();
        List<TreeNode> ql = new ArrayList();
        path(root, p, pl);
        path(root, q, ql);
        int i = pl.size()-1;
        for (; i > 0; i--) {
        	if (ql.contains(pl.get(i))) break;
        }
        return pl.get(i);
    }
}