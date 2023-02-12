/*
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9

Solution approch
Do the merge sort first
Idea

while mergeing two Left and Right array
if we get all elements from left array then first then get all element from right array first then there can not be any inversion pair
but if we have to get the element from right array which means inversion elements exists.
then all remaining items of left array will be added in ans (as these big elements of left array are cuasing inversion pair)
and if one element if bigger in left all element in left will be bigger;
ans = ans + all remaining items of left array
 */
package Sorting;

public class InversionPairCount {
    int ans=0;
    int mod=(int)1e9+7;
    public int solve(int[] A) {
        Sort(A,0,A.length-1);
        return ans;
    }
    void Sort(int[] A,int L,int R){
        if(L==R)
            return;
        int mid=(R+L)/2;
        Sort(A,L,mid);
        Sort(A,mid+1,R);
        merge(A,L,R,mid);
    }
    void merge(int[] A,int L,int R,int mid){
        int[] merged=new int[R-L+1];
        int idx=0;
        int i=L,j=mid+1;
        while(i<=mid && j<=R){//[1 2 9 10] [3 4 5 12]  =  1 2
            if(A[i]<=A[j])
                merged[idx++]=A[i++];
            else{
                merged[idx++]=A[j++];
                ans=(ans+mid-i+1)%mod;
            }
        }
        while(i<=mid)
            merged[idx++]=A[i++];
        while(j<=R){
            merged[idx++]=A[j++];
        }
        int k=L;
        for(i=0;i<merged.length;i++){
            A[k++]=merged[i];
        }
    }
}
