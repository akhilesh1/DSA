/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //At every node check if i have p on left and  on right
        if(root==null) return root;
        if(root==p || root==q) return root;

        var oneExistsInLeft=LowestCommonAncestor(root.left,p,q);
        var oneExistsInRight=LowestCommonAncestor(root.right,p,q);

        if(oneExistsInLeft!=null && oneExistsInRight!=null)
            return root;
        else if(oneExistsInLeft==null)
            return oneExistsInRight;
        else
            return oneExistsInLeft;
             


    }
}