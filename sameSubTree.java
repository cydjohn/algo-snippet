// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
import java.io.*;
import java.util.*;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
	static Map<String, Integer> map = new HashMap<>();
	public static Map<String, Integer> sameSubTree(TreeNode root) {
		dfs(root);
		Map<String, Integer> res = new HashMap<>();
		for (String key : map.keySet()) {
			if (key.length() > 3 && map.get(key) > 1) res.put(key, map.get(key));
		}
		return res;
	}
	private static String dfs(TreeNode root) {
		if (root == null) return "#";
		String left = dfs(root.left);
		String right = dfs(root.right);
		String all = Integer.toString(root.val) + left + right;
		if (!map.containsKey(all)) map.put(all, 0);
		map.put(all, map.get(all)+1);
		return all;
	}
	public static void main(String[] args) {
	    TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(3);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(4);
	    root.right.right = new TreeNode(5); 
	    Map<String, Integer> res = sameSubTree(root);
	    for (String key : res.keySet()) {
	        System.out.println(key + " " + map.get(key));
	    }
	}
}