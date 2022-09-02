/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Solution approach.
Please notice array is unsorted barn locations only
Since we can not directly count min distance
bu we can count how many cows we can have if we have *given distance*
this is hit and trial method we will binary search for complete distance range [0, A[N-1]-A[0]]
 */
package Searching;

public class AggressiveCows {
    public int solve(int[] A, int B)
    {
        Arrays.sort(A);
        int N=A.length;
        int L=0,R=A[N-1]-A[0];
        int ans=0;
        while(L<=R)
        {
            int mid=L+(R-L)/2;//mid is the distance
            int count1=countCows(A,mid);
            int count2=countCows(A,mid+1);
            //System.out.println("Mid:"+mid+"Count1:"+count1+"Count2:"+count2);
            if(count1>=B && count2<B){
                ans=mid;
                break;
            }
            else if(count1>=B)
                L=mid+1;
            else
                R=mid-1;
        }
        return ans;
    }
    //cows count in given distance
    //Array is representing barn location
    //D is minimum distance you need to keep between cows
    //return How many max cows you can keep ,maintain the min distance D
    public int countCows(int[] A,int D){
        int ans=1;
        int N=A.length;
        int prev=A[0];
        for(int i=1;i<N;i++){
            if((A[i]-prev)>=D)
            {
                ans++;
                prev=A[i];
            }
        }
        return ans;
    }
}
