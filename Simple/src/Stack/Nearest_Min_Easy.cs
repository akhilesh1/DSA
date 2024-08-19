
/*
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is integer array A.



Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.



Example Input
Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]
*/
class Solution {
    public List<int> prevSmaller(List<int> A) {
        int N=A.Count;
        var ans=new int[N];
        var stc=new Stack<int>();
        for(int i=0;i<N;i++)
        {
            while(stc.Count>0 && stc.Peek()>=A[i])
                stc.Pop();

            if(stc.Count>0 && stc.Peek()<A[i])
            {
                ans[i]=stc.Peek();
            }
            else
                ans[i]=-1;
            stc.Push(A[i]);
        }
        return ans.ToList();
    }
}
