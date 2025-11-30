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
        //if(root==null) return true;

        if(GetHeight(root)==-1)
            return false;

        return true;
    }

    public int GetHeight(TreeNode root)
    {
        if(root==null) return 0;
        int leftHeight=0;
        int rightHeight=0;
        if(root.left!=null)
            leftHeight=GetHeight(root.left);
        if(root.right!=null)
            rightHeight=GetHeight(root.right);
        
        if(leftHeight==-1 || rightHeight==-1)
            return -1;
        if(Math.Abs(leftHeight-rightHeight)>1)
            return -1;

        return 1+Math.Max(leftHeight,rightHeight);
    }
}