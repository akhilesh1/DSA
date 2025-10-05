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
    public bool IsBalanced(TreeNode root) {
        
        if(GetHeight(root)==-1) return false;

        return true;
    }
    public int GetHeight(TreeNode node)
    {
        if(node==null) return 0;
        int l=GetHeight(node.left);
        if (l == -1) return -1;
        int r=GetHeight(node.right);
        if (r == -1) return -1;

        if (Math.Abs(l - r) > 1)
            return -1;

        return Math.Max(l,r)+1;
    }
}