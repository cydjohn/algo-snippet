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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return ret;
        queue.offer(root);

        while (!queue.isEmpty()) {
        	int size = queue.size();        	
        	for (int i = 0; i < size; i++) {
        		TreeNode x = queue.poll();
        		if (i == 0) ret.add(x.val);
        		if (x.right != null) queue.offer(x.right);
        		if (x.left != null) queue.offer(x.left);
        	}
        }
        return ret;
    }
}