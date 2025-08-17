public class Solution {
    public int PivotIndex(int[] nums) {
        //1,7,3,6,5,6
        //28,27,20,17,11,6
        int N=nums.Length;
        if(N==1)
            return 0;

        int[] prefixArr=new int[N];
        prefixArr[N-1]=nums[N-1];
        for(int i=N-2;i>=0;i--)
        {
            prefixArr[i]=nums[i]+prefixArr[i+1];
        }

        int leftSum=nums[0];
        if(prefixArr[1]==0)
            return 0;
        for(int i=1;i<N;i++)
        {
            int rightSum=prefixArr[i]-nums[i];
            if (rightSum==leftSum)
                return i;
            

            if(i==N-1 && leftSum==0)
                return N-1;

            leftSum+=nums[i];
        }
        return -1;
    }
}