/*
#Equilibrium index#
Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105

Solution approach
L=0;R=0; create PS
1)for index 0 check if removing 0th can make sum zero
2)simple trverse i [1,n-1] chek if anywhere L=R return that i

 */
package ArraySimplePackage.Arrays;
public class Medium_Equilibrium_Index {
    public int solve(int[] A) {
        int[] PS=new int[A.length];
        PS[0]=A[0];
        for(int i=1;i<A.length;i++){
            PS[i]=PS[i-1]+A[i];
        }
        int L=0;
        int R=0;
        for(int i=0;i<A.length;i++){

            if(i==0){
                R=PS[A.length-1]-PS[0];
            }
            else{
                R=PS[A.length-1]-PS[i];//i+1-1
                L=PS[i-1];
            }
            if(L==R)
                return i;
        }

        return -1;
    }
}
