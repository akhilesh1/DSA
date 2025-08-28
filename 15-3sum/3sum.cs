public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        List<IList<int>> ans=new();
        Array.Sort(nums);
        int N=nums.Length;
        for(int i=0;i<N;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            
                int start=i+1;
                int end=N-1;
                while(start<end)
                {
                    int total = nums[i] + nums[start] + nums[end];
                    if(total==0)
                    {
                        ans.Add(new List<int>(){nums[start],nums[end],nums[i]});
                        start++;
                        end--;
                        while(start<end && nums[start]==nums[start-1]) start++;
                        while(start<end && nums[end]==nums[end+1]) end--;
                    }
                    else if(total<0)
                        start++;
                    else 
                        end--;
                   
                }
            
        }
        return ans;
    }
}