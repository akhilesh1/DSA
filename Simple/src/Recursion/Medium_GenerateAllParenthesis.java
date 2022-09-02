/*
Problem Description
Given an integer A pairs of parentheses,
write a function to generate all combinations of well-formed parentheses of length 2*A.


Problem Constraints
1 <= A <= 10
 */
package Recursion;

import java.util.ArrayList;

public class Medium_GenerateAllParenthesis {
    int N=0;
    ArrayList<String> ans;
    public ArrayList<String> generateParenthesis(int A) {
        N=A;
        ans=new ArrayList<String>();
        getString(0,0,"");
        return ans;
    }
    void getString(int openedCount,int closedCount,String str){
        System.out.println("Opened:"+openedCount+" Closed:"+closedCount+" STR :"+ str);
        if(openedCount==N && closedCount==N){
            ans.add(str);
            return;
        }
        if(openedCount<N)
            getString(openedCount+1,closedCount,str+"(");
        if(closedCount<openedCount)
            getString(openedCount,closedCount+1,str+")");
    }
}
