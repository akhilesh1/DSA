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
       if(root==null) return null;

       if(root==p) return root;
       if(root==q) return root;

       TreeNode leftLCA=LowestCommonAncestor(root.left,p,q);
       TreeNode rightLCA=LowestCommonAncestor(root.right,p,q);

       if(leftLCA!=null && rightLCA!=null)// becuase of BST root will be definately lowest 
            return root;
        else if (leftLCA==null)
            return rightLCA;
        else
            return leftLCA;
    }
}