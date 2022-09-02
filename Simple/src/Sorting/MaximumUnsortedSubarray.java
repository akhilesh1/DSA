/*
# Maximum Unsorted Subarray #
Problem Description
Given an array A of non-negative integers of size N.
Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array,
then the whole array should get sorted. If A is already sorted, output -1.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Solution Approach
First find START index then END index where the sequence is breaking


 */
package Sorting;
public class MaximumUnsortedSubarray {
    public int[] subUnsort(int[] A) {
        int start=-1,end=-1;
        int N=A.length;
        for(int i=1;i<N;i++){
            if(A[i]<A[i-1])
            {
                start=i-1;
                break;
            }
        }
        if(start==-1)
            return new int[] {-1};

        for(int i=N-1;i>0;i--){
            if(A[i-1]>A[i])
            {
                end=i;
                break;
            }
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++)
        {
            max=Math.max(max,A[i]);
            min=Math.min(min,A[i]);
        }
        //check in left
        for(int i=start;i>=0;i--){
            if(A[i]>min)
                start=i;
        }
        //check in right
        for(int i=end;i<N;i++){
            if(A[i]<max)
                end=i;
        }
        return new int[] {start,end};
    }
}
