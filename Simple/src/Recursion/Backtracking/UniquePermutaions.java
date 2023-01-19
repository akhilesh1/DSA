/*
Problem Description
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9

0 <= A[i] <= 10

Solution approch
instead of iterating over input array
take freq map/hashmap of array
 */
package Recursion.Backtracking;
import java.util.*;
public class UniquePermutaions {
    int N;
    ArrayList<Integer> newCur;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        N=A.size();
        newCur=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int[] map=new int[11];
        //Fill hashmap
        for(int i=0;i<A.size();i++)
            map[A.get(i)]++;
        getUniquePermutation(result,new ArrayList(),0,map);
        return result;
    }


    void getUniquePermutation(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> cur,int idx,int[] map)
    {
        if(idx==N){//index crossed size
            result.add(new ArrayList<>(newCur));
            return;
        }
        for(int i=0;i<=10;i++)
        {
            if(map[i]>0){//if freq map has value
                newCur.add(i);
                map[i]--;
                getUniquePermutation(result,cur,idx+1,map);
                newCur.remove(newCur.size()-1);
                map[i]++;
            }
        }
    }
}



