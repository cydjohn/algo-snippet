/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution 1:
//List<String>, String is dynamic的处理方法： 
public class Solution {
	List<String> ret = new LinkedList<String>();
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) return ret;
		subPath(root, "");
		return ret;
	}
    //more efficient way for path traversal
	private void subPath(TreeNode root, String path) {
		if (root == null) return;
		path += root.val;//from int to string directly
		if (root.left == null && root.right == null) ret.add(path);//path here is a pointer, but it has different address for each subPath call, because we add new part into it in the argument of subpath.
		subPath(root.left, path + "->");
		subPath(root.right, path + "->");
	}
}

//Solution 2:
public class Solution {
	private boolean found = false;
    //get the ancestor path list of node x, the path list includes node x
	private void path(TreeNode root, TreeNode x, List<Integer> ret) {
		if (root == null || found == true) return;
		ret.add(root.val);
		if (root == x) {			
			found = true;
			return;
		}
		if(found == false) path(root.left, x, ret);
		if(found == false) path(root.right, x, ret);
		if(found == false) ret.remove(ret.size()-1);
	}

    //find the leaves
	private void dfs(TreeNode root, List<TreeNode> ret) {
		if (root == null) return;
		dfs(root.left, ret);
		if (root.left == null && root.right == null) ret.add(root);
		dfs(root.right, ret);
	}

    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> ans = new LinkedList();
        List<TreeNode> leaf = new ArrayList();
        dfs(root, leaf);
        for (TreeNode c : leaf) {
        	List<Integer> p = new ArrayList();
        	found = false;
        	path(root, c, p);
        	//convert arraylist to string with separators
        	StringBuilder strbul = new StringBuilder();
        	strbul.append(p.get(0));
        	for (int i = 1; i < p.size(); i++) {
        		strbul.append("->");
        		strbul.append(p.get(i));        		
        	}
        	ans.add(strbul.toString());
        }
        return ans;
    }
}