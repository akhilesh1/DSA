/*
Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
0 <= A[i][j] <= 103

Solution Approach
1)get and store the indexes,total zero count where we have zero
2)iterate by total zero count on that index array,
for each coordinate traverse row wise or col wise fixing that row and col and make zero

 */

package ArraySimplePackage.Arrays;

public class Medium_RowToColZero {
    public int[][] solve(int[][] A) {
        int r=A.length;
        int c=A[0].length;
        int cordIndex=0;
        int[][] cord= new int[r*c][2];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]==0){
                    cord[cordIndex][0]=i;
                    cord[cordIndex][1]=j;
                    cordIndex++;
                }
            }
        }
        for(int i=0;i<cordIndex;i++){
            int rowIndex=cord[i][0];
            int colIndex=cord[i][1];
            //update that column
            for(int col=0;col<c;col++){
                A[rowIndex][col]=0;
            }
            //update that row
            for(int row=0;row<r;row++){
                A[row][colIndex]=0;
            }
        }

        return A;
    }
}
