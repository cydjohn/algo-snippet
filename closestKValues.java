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
	Queue<Integer> res = new LinkedList();//必须用queue而不能直接用linked list来声明，peek()等功能都是从queue继承来的
	boolean found = false;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorder(root, target, k);
        return new ArrayList(res);//返回的结果必须是List的，而不是queue，两者是并列的，所以要重新生成一个
    }
    private void inorder(TreeNode root, double target, int k) {
    	if (root == null || found) return;
    	inorder(root.left, target, k);
    	if (res.size() < k) {
    		res.add(root.val);
    	}else {
    		if (Math.abs(res.peek() - target) > Math.abs(root.val - target)) {
    			res.poll();
    			res.add(root.val);
    		}else {//因为BST的in order是有序的，如果找到一个点diff不再减小，则说明已经找到k个符合条件的值了。
    			found = true;
    			return;
    		}
    	}
    	inorder(root.right, target, k);
    }
}