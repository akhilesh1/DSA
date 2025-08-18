public class Solution {
    
    public int[] TwoSum(int[] nums, int target) {
        int N=nums.Length;
        Dictionary<int,int> dic=new();
        for(int i=0;i<N;i++)
        {
            if(dic.ContainsKey(target-nums[i]))
                return [dic[target-nums[i]],i];
            else
                dic[nums[i]]=i;
        }
        return [];
    }
}