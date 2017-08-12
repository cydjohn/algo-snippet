/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BST Character O(logn)
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.right != null) {
            TreeNode res = p.right;
            while (res.left != null) res = res.left;
            return res;
        } else {
            TreeNode res = root;
            TreeNode lastLeft = null;
            while (res != null) {
                if (res == p || res == null) break;
                if (res.val > p.val) {
                    lastLeft = res;
                    res = res.left;   
                }
                else res = res.right;
            }
            if (res == p) return lastLeft;
            else return null;
        }
    }
}

//dfs O(V+E)
public class Solution {
	boolean foundp = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        //注意这里必须设置好return函数，否则被调用的函数无法返回结果到答案中
        TreeNode left = inorderSuccessor(root.left, p);
        if (left != null) return left;
        if (foundp) return root;
        if (root == p) foundp = true;
        TreeNode right = inorderSuccessor(root.right, p);
        if (right != null) return right;   
        return null;    
    }
}
