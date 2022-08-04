/*
Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.

An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108

Solution Approach
from right to left <-----|
Carry forward the maxElement from right and compare it with current element
increase count if we encounter greater element

 */
package Arrays.All;

import java.util.ArrayList;

public class Easy_Leaders {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N=A.size();
        ArrayList<Integer> resultList=new ArrayList<Integer>();
        resultList.add(A.get(N-1));
        int curMax=-1;

        for(int i=N-2;i>=0;i--){
            curMax=Math.max(curMax,A.get(i+1));
            if(A.get(i)>curMax)
                resultList.add(A.get(i));
        }
        return resultList;
    }
}
