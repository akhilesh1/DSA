/*
Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109

Solution Approarch

 */
package Hashing;
import java.util.Arrays;
import java.util.HashMap;

public class CountRightTriangles {
    public int solve(int[] A, int[] B) {
        int N=A.length;
        HashMap<Integer,Integer> xAxisCount=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> yAxisCount=new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++)
        {
            int x=A[i],y=B[i];
            if(xAxisCount.containsKey(x))
                xAxisCount.put(x,xAxisCount.get(x)+1);
            else
                xAxisCount.put(x,1);

            if(yAxisCount.containsKey(y))
                yAxisCount.put(y,yAxisCount.get(y)+1);
            else
                yAxisCount.put(y,1);
        }
        int ans=0;
        for(int i=0;i<N;i++)
        {
            ans+=((xAxisCount.get(A[i])-1)*(yAxisCount.get(B[i])-1));
        }
        return ans;
    }
}
