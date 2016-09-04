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


//bfs with constant space + dummy node
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode p = dummy;
        while (root != null) {
            if (root.left != null) {
                p.next = root.left;
                p = p.next;
            }
            if (root.right != null) {
                p.next = root.right;
                p = p.next;
            }
            root = root.next;
            if (root == null) {
                root = dummy.next;
                p = dummy;
                dummy.next = null;
            }
        }
    }
}

/*因为binary tree不是perfect，有可能出现最左边的叶子的next指针直接指向最右边的叶子，如果树很大时，由于dfs是先遍历左边再到右边，有可能出现右边的上一层的next顺序还有处理好，则最左边的叶子无法通过上层的next指针访问最右边的叶子；而如果tree是perfect的，dfs可用，因为上述情况不会出现，next指针总是只能指向其相邻的右边叶子。*/