/*
Problem Description
Given a sorted array of integers A(0 based index) of size N, find the starting and the ending position of a given integer B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that the first element = starting position of B in A and the second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109

Solution approach
Two separate index find
1)when starting index element before that will be smaller
2)when ending index element after that will be bigger

take care of starting 0 and ending N-1 either you reach there or above cond should meet

//A[mid]>B or A[mid]==B
//if our mid is greater than search item we need to go left
//how can we go left by marking mid as last element
//####**** IMP****##if equal then also we need to go left since we need left most start index
 */
package Searching;

public class SearchForRange {
    public int[] searchRange(final int[] A, int B) {
        int N=A.length;
        int start=-1,end=-1;
        int L=0,R=N-1;
        if(N==1)
        {
            return new int[] {0,0};
        }//find start index
        while(L<=R){
            int mid=L+(R-L)/2;
            if(A[mid]==B && (mid==0 || A[mid-1]<B))
            {//
                start=mid;
                break;
            }
            else if(A[mid]<B)//if our mid is less then search item we need to go right
            {               //how can we go right by making start to mid+1
                L=mid+1;//mid+1 is moving to right
            }
            else//A[mid]>B or A[mid]==B
            //if our mid is greater then search item we need to go left
            //how can we go left by marking mid as last element
            //####**** IMP****##if equal then also we need to go left since we needleft most start index
            {
                R=mid-1;//mid -1 is moving to left
            }
        }
        //if start index not found end index will also not be there
        if(start==-1)
            return new int[] {-1,-1};
        //find end index
        L=start;
        R=N-1;
        while(L<=R){
            int mid=L+(R-L)/2;
            if(A[mid]==B && (mid==N-1 || A[mid+1]>B)){
                end=mid;
                break;
            }
            else if(A[mid]>B)//means we need to go left
                R=mid-1;//we go left
            else //A[mid]<B and A[mid]==B still we need to go right since we are looking for right most element
                L=mid+1;
        }
        return new int[] {start,end};
    }
}
