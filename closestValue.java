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
	public int closestValue(TreeNode root, double target) {
		if (root == null) return root.val;
		if (root.val > target && root.left != null) {
			int tmp = closestValue(root.left, target);
			return (Math.abs(tmp - target) > Math.abs(root.val - target) ? root.val : tmp);
        } else if (root.right != null){
         	int tmp = closestValue(root.right, target);
            return (Math.abs(tmp - target) > Math.abs(root.val - target) ? root.val : tmp);
        } else return root.val;
    } 
}


