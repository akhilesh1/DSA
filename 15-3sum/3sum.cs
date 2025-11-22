public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        Array.Sort(nums);//-4,-1,-1,0,1,2
        int N=nums.Length;
        List<IList<int>> ans=new();
        int cur=0;
        for(int i=0;i<N;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int start=i+1;
            int end=N-1;
            while(start<end)
            {
                int total=nums[start]+nums[end]+nums[i];
                if(total==0)
                {
                    ans.Add(new List<int>(){nums[i],nums[start],nums[end]});
                    start+=1;
                    while(start<end && nums[start]==nums[start-1])
                        start+=1;

                }
                else if(total>0)
                    end-=1;
                else if(total<0)
                    start+=1;
            }
        }
        return ans;
    }
}