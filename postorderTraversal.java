/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recurssively
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        dfs(root, ans);
        return ans;
    }
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}

//interatively
//methods: consider the tree travelsal probrem from the most simple situation: a three-node complete tree
//考虑这个方法的原因：访问右子树再访问root很难，但是访问root再访问右子树就很自然
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        if (root == null) return list;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode x = stack.pop();
            list.add(x.val);
            if (x.left != null) stack.push(x.left);
            if (x.right != null) stack.push(x.right);
        }
        Collections.reverse(list);
        return list;
    }
}