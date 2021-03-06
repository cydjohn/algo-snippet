/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode x = queue.poll();
                list.add(x.val);
                if (x.left != null) queue.add(x.left);
                if (x.right != null) queue.add(x.right);
            }
            res.add(list); 
        }
        return res;
    }
}


