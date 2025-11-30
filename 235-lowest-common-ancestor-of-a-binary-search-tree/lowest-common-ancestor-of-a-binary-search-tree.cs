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

        var leftLCA=LowestCommonAncestor(root.left,p,q);
        var rightLCA=LowestCommonAncestor(root.right,p,q);

        if(leftLCA!=null && rightLCA!=null)
            return root;
        else if(leftLCA==null)
            return rightLCA;
        else
            return leftLCA;
             


    }
}