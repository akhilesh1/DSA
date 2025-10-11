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
    public IList<int> RightSideView(TreeNode root) {
        List<int> ans=new();
        if(root==null) return ans;
        Queue<TreeNode> queue=new();
        queue.Enqueue(root);
        while(queue.Count>0)
        {
            int last=0;
            int N=queue.Count;
            
            for(int i=0;i<N;i++)
            {
                TreeNode node=queue.Dequeue();
                last=node.val;
                if(node.left!=null) queue.Enqueue(node.left);
                if(node.right!=null) queue.Enqueue(node.right);
            }
            ans.Add(last);
        }
        return ans;
    }
}