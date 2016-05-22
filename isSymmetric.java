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