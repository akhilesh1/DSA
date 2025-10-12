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
    public bool IsValidBST(TreeNode root) {

        //Not sure how to solve if a node wrongly placed in another half of the tree
        

        return IsValidBSTDown(root,long.MinValue,long.MaxValue);
        
    }

    public bool IsValidBSTDown(TreeNode root,long minValue,long maxValue)
    {
        if(root==null) return true;

        if((root.val>=maxValue || root.val<=minValue)) return false;

        return IsValidBSTDown(root.left,minValue,root.val) && IsValidBSTDown(root.right,root.val,maxValue);
    }
}