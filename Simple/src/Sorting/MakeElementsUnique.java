
/*
Problem Description
You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.

Find the minimum number of steps.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Solution Approach
sort and check the gap of two adjecant pairs if ascending not as per sort calculate the difference
and bump up the array element as well as ans variable.
 */

package Sorting;
import java.util.Arrays;
public class MakeElementsUnique {
    public int solve(int[] A) {
        Arrays.sort(A);
        int N=A.length;
        int ans=0;
        for(int i=1;i<N;i++){
            if(A[i]<=A[i-1]){
                int dif=A[i-1]-A[i]+1;
                A[i]+=dif;
                ans+=dif;
            }
        }
        return ans;
    }
}
