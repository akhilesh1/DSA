public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) {
        Array.Sort(nums);
        List<IList<int>> ans=new();
        Backtrack(nums,0,new List<int>(),ans);
        return ans;
    }
    public void Backtrack(int[] nums,int idx,List<int> cur,List<IList<int>> ans)
    {
        if(idx==nums.Length)
        {
            ans.Add(new List<int>(cur));
            return;
        }
        cur.Add(nums[idx]);
        Backtrack(nums,idx+1,cur,ans);
        
        cur.RemoveAt(cur.Count-1);
        int next=idx+1;
        while(next<nums.Length && nums[next]==nums[next-1])
            next++;
        Backtrack(nums,next,cur,ans);
    }
}