/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*Trap: left subtree nodes must all be less than root val, so we need to keep root val to check this condition while going deeper with dfs.*/
public class Solution {
    public boolean isValidBST(TreeNode root) {
    	return isBST(root, null, null);
    }
    //不要初始化min为Integer.MIN_VALUE，因为又可能孩子的值就为MIN，导致return false;
    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
    	if (root == null) return true;
    	if (min != null && min.val >= root.val) return false;
    	if (max != null && max.val <= root.val) return false;
    	//这里不需要math.min(max, root.val)因为如果当前root的值小于min,则在上一步便return false了，所以在这里确保了root的值大于min
    	return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}