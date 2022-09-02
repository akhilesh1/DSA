/*
Problem Description
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N

Solution approach
Trick
From the left keep max element if any where i==max element we can count that as a chunk

 */
package Sorting;

public class CountChunksWhichCanBeSorted {
    public int solve(int[] A)
    {
        int N=A.length;
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<N;i++){
            if(max<A[i])
                max=A[i];
            if(i==max)
                count++;
        }
        return count;
    }
}
