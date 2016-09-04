/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//从简单的树开始recurssive看问题
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        
        //the use of temp reference
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null) root = root.right;
        root.right = temp;
    }
}