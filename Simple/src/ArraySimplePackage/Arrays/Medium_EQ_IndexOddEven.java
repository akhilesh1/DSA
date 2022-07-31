/*
#Count indices to make sum of odd and even indexed elements equal by removing an array element
Problem Description
Given an array, arr[] of size N,
the task is to find the count of array indices
such that removing an element from these indices makes
    the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
1 <= n <= 105
-105 <= A[i] <= 105

Solution Approach.
Need two PS arrays for odd even psE and psO

1)[1,N-1] crete PS (handle 0th case seperately)
2)Iterate [1,N-1] , after iTH index odd and even arrays will be interchanging.
calculate Esum , Osum check if they are equal at every iteration count++
(handle 0th index removal seperately)



 */
package ArraySimplePackage.Arrays;

public class Medium_EQ_IndexOddEven {
}
