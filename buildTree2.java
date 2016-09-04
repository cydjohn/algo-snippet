//105. Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }
    private TreeNode build(int[] preorder, int[] inorder, int ps, int is, int n) {
    	if (n == 0) return null;
    	TreeNode root = new TreeNode(preorder[ps]);
        /*find the root in inorder array*/
    	int i = is;
        while (root.val != inorder[i]) i++;
        /*get the length of root.left*/
    	int len = i - is; 
    	root.left = build(preorder, inorder, ps+1, is, len);
    	root.right = build(preorder, inorder, ps+len+1, i+1, n-len-1); //be careful of value of new ps, ps != is, don't assign i+1 to ps
    	return root;
    }
}