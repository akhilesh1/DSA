/*
Problem Description
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109

Solution approach
just check peak condition
else we are ascending or descending area move to peak (right or left)
 */
package Searching;

public class FindGreaterOrEqualPeak {
    public int solve(int[] A) {
        int N=A.length;
        int L=0,R=N-1;
        int ans=0;
        if(N==1)
            return A[0];
        while(L<=R)
        {
            int mid=(L+R)/2;
            if((mid==0 || A[mid]>=A[mid-1]) && (mid==N-1 || A[mid]>=A[mid+1])){
                ans=A[mid];
                break;
            }
            else if(mid==0 || A[mid]>A[mid-1])
                L=mid+1;//go right
            else
                R=mid-1;//go left
        }
        return ans;
    }
}
