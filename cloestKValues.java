/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BST's inorder traversal is in ascending order.
//Queue = insert from back and remove from front. used to keep a window of k
//O(n)
//haven't use the condition of "balanced"
public class Solution {
	Queue<Integer> res = new LinkedList();
	boolean found = false;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorder(root, target, k);
        return new ArrayList(res);
    }
    private void inorder(TreeNode root, double target, int k) {
    	if (root == null || found) return;
    	inorder(root.left, target, k);
    	if (res.size() < k) {
    		res.add(root.val);
    	}else {
    		if (Math.abs(res.peek() - target) > Math.abs(root.val - target)) {
    			res.poll();
    			res.add(root.val);
    		}else {
    			found = true;
    			return;
    		}
    	}
    	inorder(root.right, target, k);
    }
}