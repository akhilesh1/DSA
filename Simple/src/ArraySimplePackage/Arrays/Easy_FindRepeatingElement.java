/*
Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109

Solution
Keep a hashmap as soon as encounter duplicate return
 */
package ArraySimplePackage.Arrays;

import java.util.HashMap;

public class Easy_FindRepeatingElement {
    public int solve(int[] A) {
        int N=A.length;
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++){
            if(hs.containsKey(A[i]))
                hs.put(A[i],hs.get(A[i])+1);
            else
                hs.put(A[i],1);
        }
        for(int i=0;i<N;i++){
            if(hs.get(A[i])>1)
                return A[i];
        }

        return -1;
    }
}
