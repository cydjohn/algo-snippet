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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	//maintain a linkedlist to use the method addFirst()
        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> level = new LinkedList();
        	for (int i = 0; i < size; i++) {
        		TreeNode x = queue.poll();
        		if (x != null) {
        			level.add(x.val);
        			queue.add(x.left);
        			queue.add(x.right);
        		}
         	}
         	if (!level.isEmpty()) {
         		ret.addFirst(level);
         	}
        }
        //cast the linkedlist to list
        List ret1 = ret;
        return ret1;
    }
}