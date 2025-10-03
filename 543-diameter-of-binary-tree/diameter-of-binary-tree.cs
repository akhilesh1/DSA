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
    int dia=0;
    public int DiameterOfBinaryTree(TreeNode root) 
    {
        GetMaxDia(root);
        return dia;
    }

    public int GetMaxDia(TreeNode root)
    {
        if(root==null)
            return 0;
        int l=GetMaxDia(root.left);
        int r=GetMaxDia(root.right);
        dia=Math.Max(l+r,dia);
        return 1 + Math.Max(l, r);
    }
}