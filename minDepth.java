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
//地雷：注意minDepth的定义
public class Solution {
    public int minDepth(TreeNode root) {
       if (root == null) return 0;
       else if (root.left == null) return 1 + minDepth(root.right);
       else if (root.right ==  null) return 1 + minDepth(root.left);
       else return 1 + Math.min(minDepth(root.left), minDepth(root.right));  
    }
}

//interatively
public class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        TreeNode fr = new TreeNode(0);
        int ans = 0; 
        queue.add(root);

        outerloop:
        while (!queue.isEmpty()) {
        	int lsize = queue.size();
        	for (int i = 0; i < lsize; i++) {
        		TreeNode x = queue.poll();
        		if (x != null) {
        			if (x.left == null && x.right == null) {
        				ans++;
        				break outerloop;
        			}
        			else if (i == lsize - 1) ans++;
        			if (x.left != null) queue.add(x.left);
        			if (x.right != null) queue.add(x.right);
        		}
        	}
        }
        return ans;
    }
}


