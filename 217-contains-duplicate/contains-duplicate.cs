public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        //1,2,3,1
        HashSet<int> set=new();
        int N=nums.Length;
        for(int i=0;i<N;i++)
        {
            if(set.Contains(nums[i]))
                return true;
            else
                set.Add(nums[i]);
        }
      
        return false;
    }
}