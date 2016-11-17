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
	Map<Integer, List<Integer>> map = new HashMap();
	Queue<TreeNode> q = new LinkedList();
	Queue<Integer> cols = new LinkedList();
	int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        bfs(root);
        for (int i = min; i <= max; i++) {
        	res.add(map.get(i));
        }
        return res;
    }
    private void bfs(TreeNode root) {
    	q.add(root);
    	cols.add(0);
    	while (!q.isEmpty()) {
    		TreeNode cur = q.poll();
    		int col = cols.poll();
    		if (!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
    	    map.get(col).add(cur.val);
    	    if (cur.left != null) {
    	    	q.add(cur.left);
    	    	cols.add(col - 1);
    	    	if (col <= min) min = col-1;
    	    }
    	    if (cur.right != null) {
    	    	q.add(cur.right);
    	    	cols.add(col+1);
    	    	if (col >= max) max = col+1;
    	    }
    	}
    }
}

//这道题不好用DFS，因为要求输出的每一个list都是从上到下的，但是dfs当树不平衡时，有可能出现在左子树的某个点的和柚子树的某点点vertical order相同，但是左子树的先访问，而在其上的柚子树没有被访问，所以需要按层次访问确保不出现这样的情况。