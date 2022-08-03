/*
Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2

Solution approach
count occurance  of 0 and 1 then simply fill in
 */
package ArraySimplePackage.Arrays;

public class Easy_Sort012_SortColors {
    public int[] sortColors(int[] A) {
        int N=A.length;
        int zeroCount=0;
        int oneCount=0;
        int[] ans=new int[N];
        for(int i=0;i<N;i++){
            if(A[i]==0)
                zeroCount++;
            else if(A[i]==1)
                oneCount++;
        }
        for(int i=0;i<N;i++){
            if(zeroCount-->0)
                ans[i]=0;
            else if(oneCount-->0)
                ans[i]=1;
            else
                ans[i]=2;
        }
        return ans;
    }
}
