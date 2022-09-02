package Searching;
/*
Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106

Solution approach
trick here is we can traverse the matrix linerly
//now full range will be [0, N*M-1]
and from this range for any number i [0, N*M-1]
we can get corresponding coordinates as i/M,i%M
where M is number of columns

rest is simple binary search
 */


public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {
        int N=A.length;
        int M=A[0].length;
        int ans=0;
        //now full range will be [0, N*M-1]
        int L=0,R=N*M-1;
        while(L<=R)
        {
            int mid=(L+R)/2;
            if(A[mid/M][mid%M]==B){//column count division and mod will get us there
                ans=1;
                break;
            }
            else if(B<A[mid/M][mid%M])//B is small go left
                R=mid-1;
            else// B is large go right
                L=mid+1;
        }
        return ans;
    }
}
