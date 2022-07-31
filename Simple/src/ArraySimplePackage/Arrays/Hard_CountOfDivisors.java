/*
Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106

Solution approach
//Prepare the sieve array for all numbers 1 to Max of Array A
//iterate on the input array and get the divisor for each element
 */

package ArraySimplePackage.Arrays;

public class Hard_CountOfDivisors {
    public int[] solve(int[] A) {
        int N=A.length;//4
        int N1=0;
        for(int i=0;i<N;i++){
            N1=Math.max(A[i],N1);
        }
        int[] devisor=new int[N1+1];
        //Applying seive
        for(int i=1;i<=N1;i++){
            for(int j=i;j<=N1;j+=i){//this is the seive logic next mutiple will be at same distance
                devisor[j]+=1;
            }
        }
        int[] result=new int[N];
        //int idx=N1;
        for(int i=0;i<N;i++)
        {
            result[i]=devisor[A[i]];
        }
        return result;
    }
}

