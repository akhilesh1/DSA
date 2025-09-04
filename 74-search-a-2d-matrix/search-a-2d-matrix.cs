public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int rows=matrix.Length;
        int cols=matrix[0].Length;
        int N=rows*cols;

        int left=0;
        int right=N-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            int cur=getValue(mid,matrix);
            if(cur==target) return true;
            else if(cur<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return false;
    }

    int getValue(int i,int[][] matrix)
    {
        //r =1 c=2 n 6
        int rows=matrix.Length;
        int cols=matrix[0].Length;
        int r=i/cols;//6/4= 1
        int c=i%cols;//6%3 =3

        return matrix[r][c];
    }

}