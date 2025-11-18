public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        List<IList<int>> ans=new();
        Backtrack(nums,new List<int>(),ans);
        return ans;
    }

    public void Backtrack(int[] nums,List<int> cur,List<IList<int>> ans)
    {
        if(cur.Count==nums.Length)
        {
            ans.Add(new List<int>(cur));
            return;
        }
        
        for(int i=0;i<nums.Length;i++)
        {
            if(!cur.Contains(nums[i]))
            {
                cur.Add(nums[i]);
                Backtrack(nums,cur,ans);
                cur.RemoveAt(cur.Count-1);
            }
        }
    }
}