/*
Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints
1 <= N <= 10000

1<= A[i] <=1000
 */

package Sorting;

import java.util.Arrays;

public class SumTheDifference {
    int mod=(int)1e9+7;
    public int solve(int[] A) {

        int N=A.length;
        long ans=0;
        Arrays.sort(A);
        // 3 7 1 5 8 4
        for(int i=0;i<N;i++){//i 2^100000
            long AiGreaterCount=getPow(2,i); //before i every thing is less then A[i]
            //lessCount%=mod;
            long AiLessCount=getPow(2,N-i-1);
            //greaterCount%=mod;
            ans=(ans+mod+(A[i]*(AiGreaterCount-AiLessCount)%mod)%mod)%mod;
            ans%=mod;
            //ans=(ans+mod)%mod;
        }
        return (int)ans;
    }
    long getPow(int A,int B){
        if(B==0)
            return 1;
        long result=A;
        for(int i=1;i<B;i++){
            result=(result*A)%mod;
        }
        return result;
    }
}
