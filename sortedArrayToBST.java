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
        return dfs(nums, 0, nums.length-1);
    }
    private TreeNode dfs(int[] nums, int start, int end) {
    	if (start > end) return null;
    	int mid = (start + end)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = dfs(nums, start, mid-1);
    	root.right = dfs(nums, mid+1, end);
    	return root;
    }
}

//versin 2:
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }
    private TreeNode dfs(int[] nums, int st, int n) {
    	if (n == 0) return null;
    	int mid = st + (n-1)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	int len = mid - st;
    	root.left = dfs(nums, st, len);
    	root.right = dfs(nums, mid+1, n-len-1);
    	return root;
    }
}