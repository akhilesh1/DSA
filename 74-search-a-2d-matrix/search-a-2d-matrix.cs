public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int l=matrix.Length*matrix[0].Length;
        int start=0;
        int end=l-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int cur=GetNumber(mid,matrix);
            if(cur==target) return true;
            else if(cur<target) start=mid+1;
            else end=mid-1;
        }
        return false;
    }
    private int GetNumber(int idx,int[][] matrix)
    {
        int m=matrix.Length;
        int n=matrix[0].Length;
        int i=(idx)/n;
        int j=(idx)%n;
        return matrix[i][j];
    }
}