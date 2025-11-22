public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int,int> dic=new();
        int N=nums.Length;
        dic.Add(nums[0],0);
        for(int i=1;i<N;i++)
        {
            if(dic.ContainsKey(target-nums[i]))
                return new[]{dic[target-nums[i]],i};
            else
                if(dic.ContainsKey(nums[i]))
                    continue;
                else
                    dic.Add(nums[i],i);
        }
        return new[]{0,0};
    }
}