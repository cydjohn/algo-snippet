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
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}

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


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p && root == q) return root;
        TreeNode x = lowestCommonAncestor(root.left, p, q);
        //如果p q都在左子树
        if (x != null && x != p && x != q) return x;
        //如果p q都在右子树
        TreeNode y = lowestCommonAncestor(root.right, p, q);
        if (y != null && y != p && y != q) return y;
        //p, q分别在不同的子树
        if (x != null && y != null) return root;
        //x,y有一个为空，而root是p, q其中的一个
        else if (root == p || root == q) return root;
        else return x == null ? y : x;
    }
}













