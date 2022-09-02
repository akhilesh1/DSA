/*
Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

Solution approach
we need to binary search on the basis of index element if its even or odd
there are 3 cases of of our mid element  on binary search eg. 0,1  *2,*3  *4  *5,*6
1)mid on target 0,1  2,3  *4  5,6
2)mid on left of target
    A)at even index 0,1  2,*3  4  5,6
    B)at odd index  0,1  *2,3  4  5,6
3)mid on right of target
    A)at even index 0,1  2,3  4  5,*6
    B)at odd index 0,1  2,3  4  *5,6

need to handle above cases with one more skip logic since they exist in pair
 */
package Searching;

public class SearchUniqueElement {
    public int solve(int[] A) {
        int N=A.length;
        int L=0,R=N-1;
        while(L<=R){
            int mid=L+(R-L)/2;
            if((mid==0 || A[mid]!=A[mid-1])&&(mid==N-1 || A[mid]!=A[mid+1]))
                return A[mid];
            else if(mid==0 || A[mid]!=A[mid-1])// if both above condn not met one mut me true
                if(mid%2==0)//if this is even meaning its on left side *0,1 2,3  4  5,6
                    L=mid+1+1;// go right one more right skip because just just element will be same
                else//odd  0,1 2,3  4  *5,6
                    R=mid-1;//go left
            else
                if(mid%2==0)//0,1 2,3  4  5,6*
                    R=mid-1-1;//go left one more index skipped as left adjecent will be same
                else
                    L=mid+1;// go right

        }
        return -1;
    }
}
