public class Solution {
    public int MaxSubArray(int[] nums) {
        int N=nums.Length;
        if(N==1)
            return nums[0];
        int sum=0;
        int ans=int.MinValue;
        // if sum -ive and current is greater then sum then sum= current elment.
        for(int i=0;i<N;i++)
        {
            sum+=nums[i];
            if(sum>ans)
                ans=sum;
            if(sum<0)
                sum=0;
        }
        return ans;
    }
    
}