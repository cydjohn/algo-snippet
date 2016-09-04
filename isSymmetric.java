/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recurssive:
//若二叉树p与二叉树q对称，也就是说其根节点相同，p左子树应与q右子树对称，同理，p右子树应与q左子树对称.
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymTree(root.left, root.right);
    }
    private boolean isSymTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return (isSymTree(p.left, q.right) && isSymTree(p.right, q.left));
    }
}

//worse method:
public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	List<Integer> left = new ArrayList();
    	List<Integer> right = new ArrayList();
    	leftDFS(root, left);
    	rightDFS(root, right);
    	return (left.equals(right));
    }

    private void leftDFS(TreeNode root, List<Integer> left) {
    	if (root == null) {
    		left.add(null);
    		return;
    	}
    	left.add(root.val);
    	leftDFS(root.left, left);
    	leftDFS(root.right, left);
    }

    private void rightDFS(TreeNode root, List<Integer> right) {
    	if (root == null) {
    		right.add(null);
    		return;
    	}
    	right.add(root.val);
    	rightDFS(root.right, right);
    	rightDFS(root.left, right);
    }
}

