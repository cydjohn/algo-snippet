//106. Construct Binary Tree from Inorder and Postorder Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//利用不同访问顺序的性质
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, inorder, 0, 0, inorder.length);
    }
    private TreeNode build(int[] postorder, int[] inorder, int ps, int is, int n) {
    	if (n == 0) return null;
        //找到当前树的root
        //postorder的最后访问root
    	TreeNode root = new TreeNode(postorder[ps+n-1]);
        //inorder先访问root.left
    	int i = is;
        //在inorder[]中找到root
    	while(root.val != inorder[i]) i++;
    	int len = i - is; //length of left tree
    	root.left = build(postorder, inorder, ps, is, len);
    	root.right = build(postorder, inorder, ps+len, i+1, n-len-1);
    	return root;
    }
}