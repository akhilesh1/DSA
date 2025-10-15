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
        int ans=0;
        GetGoodNodesCount(root,int.MinValue,ref ans);
        return ans;
    }

    public void GetGoodNodesCount(TreeNode root,int parentValue,ref int ans)
    {
        
        if(root==null) return;

        if(root.val>=parentValue)
            ans++;

        GetGoodNodesCount(root.left,Math.Max(root.val,parentValue), ref ans);
        
        GetGoodNodesCount(root.right,Math.Max(root.val,parentValue),ref ans);

    }
}