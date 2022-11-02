/*
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105

Solution approach LNR
Iterate while either stack is null or node is null
Part 1 Left
    store the node
    go left
Part 2 Node Right
    get the node from stack
    print()
    go right

 */
package Tree;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class InOrderIterative {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        TreeNode cur=A;
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        //LNR (Left Node Right)
        while(cur!=null || !st.isEmpty()){//Either stack is empty or curr node is null
            //Left
            if(cur!=null)//if its a valid node o left
            {
                st.push(cur);
                cur=cur.left;
            }
            //current is null but stack is not empty
            //Node then Right(from stack only since current is null already)
            else
            {
                cur=st.pop();//since current is null already we can start working on the stack variable
                ans.add(cur.val);
                cur=cur.right;
            }

        }
        return ans;
    }
}
