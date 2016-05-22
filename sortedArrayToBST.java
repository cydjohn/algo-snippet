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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length-1);
    }
    
    //不要随意使用arraycopy,新建数组的memory cost很大，将array index做为参数传入
    private TreeNode dfs(int[] nums, int start, int end) {
    	if (start > end) return null;
    	int mid = (start + end)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = dfs(nums, start, mid-1);
    	root.right = dfs(nums, mid+1, end);
    	return root;
    }
}