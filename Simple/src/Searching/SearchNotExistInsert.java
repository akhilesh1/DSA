package Searching;
/*
Problem Description
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 106

Solution Approach
if we are at last index and not previous element is smaller we can consider that as an answer
 */
public class SearchNotExistInsert {
    public int searchInsert(int[] A, int B) {
        int N=A.length;
        int L=0,R=N-1;
        int ans=0;
        while(L<=R)
        {
            int mid=(L+R)/2;
            if(A[mid]==B){
                ans=mid;
                break;
            }
            else if(A[mid]<B && ( mid+1==N || A[mid+1]>B)){
                ans=mid+1;
                break;
            }
            else if(A[mid]>B)
                R=mid-1;//go left
            else
                L=mid+1;//go right
        }
        return ans;
    }
}
