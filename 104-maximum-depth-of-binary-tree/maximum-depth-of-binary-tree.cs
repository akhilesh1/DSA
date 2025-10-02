/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int MaxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int l=0;
        int r=0;
        if(root.left!=null)
            l=MaxDepth(root.left);
        if(root.right!=null)
            r=MaxDepth(root.right);

        return 1+Math.Max(l,r);
    }
}