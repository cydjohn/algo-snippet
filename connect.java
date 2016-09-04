/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//bfs with constant space
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root.left != null) {
        	TreeLinkNode st = root.left;// save the start of next level
        	while (root != null) {
        		root.left.next = root.right;
        		root.right.next = (root.next == null) ? null : root.next.left;
        		root = root.next;
        	}
        	root = st; // point to next level 
        }
    }
}

//bfs
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
        		/*check if node is null, otherwise null will be added into the queue and count for new size although it's empty, which will cause nullpointer error.*/
        		if (x.left != null) queue.offer(x.left);
        		if (x.right != null) queue.offer(x.right);
        	}
        }
    }
}

//dfs
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
        	root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

