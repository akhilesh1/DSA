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
    public int GoodNodes(TreeNode root) {
       return GetGoodNodes(root,int.MinValue);
    }

    int GetGoodNodes(TreeNode node,int val)
    {
        int cur=0;
        if(node==null)
            return 0;
        if(node.val<val) 
            cur=0;
        else
            cur=1;
        return cur+GetGoodNodes(node.left,Math.Max(node.val,val)) + GetGoodNodes(node.right,Math.Max(node.val,val));
    }
}