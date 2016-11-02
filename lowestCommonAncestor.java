//235. Lowest Common Ancestor of a Binary Search Tree
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
        List<TreeNode> p1 = new ArrayList();
        List<TreeNode> p2 = new ArrayList();
        findPath(root, p, p1);
        findPath(root, q, p2);
        for (int i = 0; i < Math.min(p1.size(), p2.size()); i++) {
            if (p1.get(i) != p2.get(i)) return p1.get(i-1);
        }
        return p1.size() > p2.size() ? p2.get(p2.size()-1) : p1.get(p1.size()-1);
    }
    private void findPath(TreeNode root, TreeNode x, List<TreeNode> list) {
        if (root == null) return; //可不检查这个corner case，如果题目假设一定能找到这个点
        list.add(root);
        if (root == x) return;
        if (root.val > x.val) findPath(root.left, x, list);
        else findPath(root.right, x, list);
    }
}