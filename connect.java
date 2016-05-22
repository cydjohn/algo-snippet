/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList();
        if (root == null) return;
        queue.offer(root);

        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeLinkNode x = queue.poll();
        		if (i == size - 1) x.next = null;
        		else x.next = queue.peek();
        		queue.offer(x.left);
        		queue.offer(x.right);
        	}
        }
    }
}