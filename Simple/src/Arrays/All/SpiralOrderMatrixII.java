/*Q1. Spiral Order Matrix II
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Solution approach
take 4 pointers and keep updating these pointers
rowStart rowEnd, colStart colEnd
*/

 class SpiralOrderMatrixII {
    public int[][] generateMatrix(int A) {
        int N=A;
        int[][] spiralResult= new int[N][N];
        int x=0,y=0,y1=N-1,x1=N-1,count=0;
        while(count<A*A){
            ///Oscar goes to akhilesh chaurasiya bravo
            //---------> top left to top right 
            for(int i=y;i<=y1;i++){
                spiralResult[x][i]=++count;
            }
            x++;
            // top right to bottom right
            for(int i=x;i<=x1;i++){        //|
                spiralResult[i][y1]=++count;//|
            }                                 //\/
            y1--;
            //bottom right to bottom left
            for(int i=y1;i>=y;i--){
                spiralResult[x1][i]=++count;
            }
            x1--;
            //bottom left to top left
            for(int i=x1;i>=x;i--){
                spiralResult[i][y]=++count;
            }
            y++;

        }
        return spiralResult;
    }
}
