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
	private List<List<Integer>> ret = new LinkedList<List<Integer>>();
	private int temp = 0;
	private int i = 0;
	private List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ret;
        findPath(root, sum, temp, path);
        return ret;
    }
    //be careful of the difference of passing instance variables and passing references
    private void findPath(TreeNode root, int sum, int temp, List<Integer> path) {
    	if (root == null) return;
    	temp += root.val;
    	path.add(root.val);
    	if (root.left == null && root.right == null && temp == sum) {
    		//don't use ret.add(path), as path will onle pass a address reference to ret, but not the content.
    		ret.add(new ArrayList<Integer>(path));
    	}
    	findPath(root.left, sum, temp, path);
    	findPath(root.right, sum, temp, path);
    	path.remove(path.size()-1);
    }
}