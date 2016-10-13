/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//bfs + hashtable
//不能用dfs的原因是题目要求当在相同的列时，输出应从上倒下，dfs无法保障
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