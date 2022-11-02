/*Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



Problem Constraints

1 <= length of the array <= 100000
-109 <= A[i], B <= 109 

Solution approach
//ans will be a fixed sized subarray 
        //we just need to find which subarray yield min swaps
        //we will keep that window sliding
*/
public class Solution {
    public int solve(int[] A, int B) {
        //ans will be a fixed sized subarray 
        //we just need to find which subarray yield min swaps
        //we will keep that window sliding
        int N=A.length;
        int size=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
        {
            if(A[i]<=B)
            size++;
        }
        if(size==N || size<=1)
            return 0;
        
        //first window
        int swaps=0;
        for(int i=0;i<size;i++)
        {
            if(A[i]>B)
            swaps++;
        }
        ans=swaps;
        //remaining window
        for(int i=size;i<N;i++)
        {
            if(A[i-size]>B)
                swaps--;
            if(A[i]>B)
                swaps++;       
            ans=Math.min(ans,swaps);
        }       
        return ans;
    }
    
}
