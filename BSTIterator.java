/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*dfs inorder traversal with stack*/
//also we could use queue.poll() function and implmented the traversal directly as inorder traversal goes
public class BSTIterator {
	Stack<Integer> stack = new Stack();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }
    private void dfs(TreeNode root) {
    	if (root == null) return;
    	/*the order of pop and push is inverse for stack*/
    	dfs(root.right);
    	stack.push(root.val);
    	dfs(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.empty());
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
}

/*dfs inorder traversal with list*/
public class BSTIterator {
	private int ptr;
	private TreeNode root;
	ArrayList<Integer> q; //don't use linkedlist here

    public BSTIterator(TreeNode root) {
        ptr = 0;
        this.root = root;
        q = new ArrayList();
        toList(root, q);
    }

    private void toList(TreeNode x, ArrayList<Integer> q) {
    	if (x == null) return;
    	//perform a inorder traversal
    	toList(x.left, q);
    	q.add(x.val);
    	toList(x.right, q); 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (ptr != q.size());
    }

    /** @return the next smallest number */
    public int next() {       
        int ret = q.get(ptr);
        ptr++;
        return ret;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

