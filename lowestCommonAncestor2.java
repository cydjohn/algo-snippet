//236. Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}

public class Solution {
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1 = new ArrayList();
        List<TreeNode> p2 = new ArrayList();
        findPath(root, p, p1);
        found = false;
        findPath(root, q, p2);
        for (int i = 0; i < Math.min(p1.size(), p2.size()); i++) {
            if (p1.get(i) != p2.get(i)) return p1.get(i-1);
        }
        return p1.size() > p2.size() ? p2.get(p2.size()-1) : p1.get(p1.size()-1);
    }
    private void findPath(TreeNode root, TreeNode x, List<TreeNode> list) {
    	//如果找到该点，提前结束递归
        if (root == null || found) return;
        list.add(root);
        if (root == x) {
            found = true;
            return;
        }
        findPath(root.left, x, list);
        findPath(root.right, x, list);
        if (!found) list.remove(list.size()-1);
    }
}
