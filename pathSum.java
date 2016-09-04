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
    List<List<Integer>> res = new ArrayList();
    List<Integer> list = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        //be careful of the difference of passing instance variables and passing references
        //don't use ret.add(path), as path will onle pass a address reference to ret, but not the content.
        if (root.left == null && root.right == null && sum == 0) res.add(new ArrayList(list));
        dfs(root.left, sum);
        dfs(root.right, sum);
        list.remove(list.size()-1);
    }
}



