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
      return CheckDown(root,long.MinValue,long.MaxValue);
    }

    public bool CheckDown(TreeNode node,long min,long max)
    {   
        if(node==null) return true;
        if(node.val<=min || node.val>=max)
            return false;
        return CheckDown(node.left,min,node.val) && CheckDown(node.right,node.val,max);
    }

}