/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://discuss.leetcode.com/topic/40924/java-recursive-o-logn-space-and-iterative-solutions-o-1-space-with-explanation-and-figure
//变化总是沿着left tree产生的，right tree只是被作为元素赋给相应的左子数，不要对右子树做相同的变换，因为很明显变化后左右子树的结构已经完全改变不存在原来的对应关系
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}