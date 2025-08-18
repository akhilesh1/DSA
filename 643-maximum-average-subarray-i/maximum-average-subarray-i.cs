public class Solution {
    public double FindMaxAverage(int[] nums, int k) {
        //1,2,3,4,5
        int N=nums.Length;
        int curSum=0;
        for(int i=0;i<k;i++)
        {
            curSum+=nums[i];
        }
        int ans=curSum;
        for(int i=k;i<N;i++)
        {
            curSum=curSum-nums[i-k]+nums[i];
            ans=Math.Max(ans,curSum);
        }
        return (double)ans/k;
    }
}