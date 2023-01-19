/*
Problem Description
Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2

Solution approach
1)Count total zeros and starting i,j of 1
2)create recursive function which end when you reach value 2 and increment if all zeros done
3)inside recursive function for every i,j
    set curent ij to -1
    try to go in all 4 paths
    reset curent ij to prev value
 */

package Recursion.Backtracking;
import java.util.*;
public class UniquePaths {
    int ans=0;
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int[] zerosAndStart=getZerosAndStart(A);
        int zeros=zerosAndStart[0];
        int x=zerosAndStart[1];
        int y=zerosAndStart[2];
        getPath(A,zeros,x,y);
        return ans;
    }
    void getPath(ArrayList<ArrayList<Integer>> A,int remainingZeros,int x,int y){
        int[] tx={-1,1,0,0};
        int[] ty={0,0,-1,1};
        if(A.get(x).get(y)==2)
        {
            if(remainingZeros==0)
                ans++;
            return;
        }
        int value=A.get(x).get(y);
        A.get(x).set(y,-1);
        for(int i=0;i<4;i++)//neighbour
        {
            int p=x+tx[i];
            int q=y+ty[i];
            if(isValidNonObstacle(p,q,A))
            {
                getPath(A,remainingZeros-(value==1?0:1),p,q);//if cur value is 1 then no need to decremenet
            }
        }
        A.get(x).set(y,value);
    }
    boolean isValidNonObstacle(int i,int j,ArrayList<ArrayList<Integer>> A)
    {
        return i<A.size() && i>=0 && j<A.get(0).size() && j>=0 && A.get(i).get(j)!=-1;
    }
    int[] getZerosAndStart(ArrayList<ArrayList<Integer>> A){
        int ans=0;
        int x=0,y=0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)==0)
                    ans++;
                else if(A.get(i).get(j)==1){
                    x=i;
                    y=j;
                }
            }
        }
        //System.out.println(" zeros:"+ans+" x:"+x+" y:"+y);
        return new int[]{ans,x,y};
    }
}
