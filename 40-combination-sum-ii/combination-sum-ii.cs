public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates); //
        List<IList<int>> ans=new();
        Backtrack(candidates,0,target,new List<int>(),ans);
        return ans;
    }

    public void Backtrack(int[] candidates,int idx,int required,List<int> cur,List<IList<int>> ans)
    {
        if(required==0)
        {
            ans.Add(new List<int>(cur));
            return;
        }
        if(idx==candidates.Length)
            return;

        if(candidates[idx]>required)
        {
            Backtrack(candidates,idx+1,required,cur,ans);
            return;
        }

        //Option1 take idx
        cur.Add(candidates[idx]);
        Backtrack(candidates,idx+1,required-candidates[idx],cur,ans);
        //Backtrack
        cur.RemoveAt(cur.Count-1);

        //Sort array and eliminate duplicate if 1,7 is taken aleady 7,1 should not be considered
        while(idx<candidates.Length-1 && candidates[idx]==candidates[idx+1])
            idx++;
        //Option2 skip idx
        Backtrack(candidates,idx+1,required,cur,ans);

    }
}