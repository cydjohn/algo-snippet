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

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	Queue<TreeNode> queue = new LinkedList();
    	queue.offer(root);

    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> level = new ArrayList();
    		for (int i = 0; i < size; i++) {
    			TreeNode x = queue.poll();
    			if (x != null) {
    				level.offer(x.val);
    				queue.offer(x.left);
    				queue.offer(x.right);
    			}
    		}
    		if (!level.isEmpty()) {
    			ret.add(level);
    		}
    	}
    	return ret;
    }
}