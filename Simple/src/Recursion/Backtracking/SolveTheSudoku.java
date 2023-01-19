package Recursion.Backtracking;

import java.util.*;
public class SolveTheSudoku {
    public void solveSudoku(char[][] A) {
        findSolution(A,0,0);
    }
    public void findSolution(char[][] A,int i,int j){
        if(i==9)// we managed to reach last row +1 meaning we have a solution
            return;
        //current char is set => simply move next
        if(A[i][j]!='.')
        {
            if(j==8) findSolution(A,i+1,0);
            else findSolution(A,i,j+1);
            return;
        }
        else//current char is not set => 1)set current valic value 2)find solutions 3)reset value
        {
            Character original_value=A[i][j];
            for(int valid_value=1;valid_value<10;valid_value++)
            {
                if(isValidValue(A,i,j,valid_value)){
                    A[i][j]=(char)(valid_value+48);
                    if(j==8)  findSolution(A,i+1,0);
                    else findSolution(A,i,j+1);

                    A[i][j]=original_value;
                }
            }

        }
    }
    public boolean isValidValue(char[][] A,int i,int j,int val)
    {
        //is valid in block
        int blockI=i/3;
        int blockJ=j/3;
        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                if((A[x+blockI*3][y+blockJ*3]-1)==48) return false;
        //is valid in row
        for(int y=0;y<9;y++) // '1'-1 =48  '2'-2=48 if same then difference is 48
            if(A[i][y]-1==48) return false;
        //is valid in column
        for(int x=0;x<9;x++) // '1'-1 =48  '2'-2=48 if same then difference is 48
            if(A[x][j]-1==48) return false;
        return true;
    }
}
