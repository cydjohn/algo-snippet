/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//better solution
//binary search(o(logh))
public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
//dfs inorder traversal
//The time complexity is O(log(n) + K) only if the tree is balanced. In the worst-case scenario the tree can have a height of n, thus the time complexity could be O(n). (n == num of nodes, k == height of BST)
public class Solution {
	int ans = -1;
	boolean found = false; //dfs stop signal
	int cnt;
    public int kthSmallest(TreeNode root, int k) {
    	cnt = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
    	if (root == null || found) return;
    	dfs(root.left);
    	cnt--;
    	if (cnt == 0) {
    		ans = root.val;
    		found = true;
    	}
    	dfs(root.right);
    }
}