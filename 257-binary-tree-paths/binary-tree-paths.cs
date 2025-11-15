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
    public IList<string> BinaryTreePaths(TreeNode root) {
        List<string> ans=new();
        DFS(root,"",ans);

        return ans;
    }

    public void DFS(TreeNode root,string cur,List<string> ans)
    {
        if(root==null)
        {
            return;
        }
        
        var nxtStr=String.Empty;
        if(string.IsNullOrEmpty(cur))
            nxtStr=root.val.ToString();
        else
            nxtStr=cur+"->"+root.val;

        if(root.left==null && root.right==null)
        {
            ans.Add(nxtStr);
            return;
        }

        DFS(root.left,nxtStr,ans);
        DFS(root.right,nxtStr,ans);
    }
}