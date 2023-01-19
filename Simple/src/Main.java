import Recursion.Backtracking.SolveTheSudoku;
import Recursion.SubSetList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        System.out.println("Hi I am working");
        char[][] input= {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};
        SolveTheSudoku sd=new SolveTheSudoku();
        sd.solveSudoku(input);
        InterviewBit obj = new InterviewBit();
        obj.getData();

    }
}

class IB
{
    protected void getData(){
        System.out.println("Inside IB");
    }
}

class InterviewBit extends IB{
    protected void getData(){
        System.out.println("Inside InterviewBit");
    }
}



