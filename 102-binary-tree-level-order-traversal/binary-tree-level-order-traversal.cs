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
    public IList<IList<int>> LevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new();
        List<IList<int>> ans=new();

        if(root==null) return ans;
        
        queue.Enqueue(root);
        while(queue.Count>0)
        {
            var cur=new List<int>();
            ans.Add(cur);
            int N=queue.Count;
            for(int i=0;i<N;i++)
            {
                TreeNode node=queue.Dequeue();
                cur.Add(node.val);

                if(node.left!=null)
                {
                    queue.Enqueue(node.left);
                    
                }
                if(node.right!=null)
                {
                    queue.Enqueue(node.right);
                }
            }
        }
        return ans;
    }
}