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
	boolean found = false;
	private void pathDFS(TreeNode root, TreeNode x, List<TreeNode> path) {
		if (root == null || found == true) return;
		path.add(root);
		if (root == x) {
			found = true;
			return;
		}
		if (found == false) pathDFS(root.left, x, path);
		if (found == false) pathDFS(root.right, x, path);
		if (found == false) path.remove(path.size()-1);
	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = new ArrayList();
        List<TreeNode> ql = new ArrayList();

        pathDFS(root, p, pl);
        found = false;
        pathDFS(root, q, ql);
        System.out.println(pl.size());
        System.out.println(ql.size());

        int i = pl.size()-1;
        for (; i >= 0; i--) {
        	if (ql.contains(pl.get(i))) break;
        }
        return pl.get(i);
    }
}