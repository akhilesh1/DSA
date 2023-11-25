/*
Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.

An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.

Example Input
Input 1:

 A = [16, 17, 4, 3, 5, 2]

Input 2:

 A = [5, 4]



Example Output
Output 1:

[17, 2, 5]

Output 2:

[5, 4]

Problem Constraints

1 <= N <= 105

1 <= A[i] <= 108

Solution Approach
from right to left <-----|
since righmost is always a leder consider that current maximum from start
Carry forward the maxElement from right and compare it with current element
increase count if we encounter greater element

 */
package Arrays.All;

import java.util.ArrayList;

public class Easy_Leaders {

   //Better solution
   public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N=A.size();
        ArrayList<Integer> resultList=new ArrayList<Integer>();
        resultList.add(A.get(N-1));
        int curMax=A.get(N-1);
        for(int i=N-2;i>=0;i--){     
            if(A.get(i)>curMax)
            {
                resultList.add(A.get(i));
                curMax=A.get(i);
            }
        }
        return resultList;
    }
}
