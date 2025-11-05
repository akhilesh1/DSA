public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        IList<IList<int>> ans=new List<IList<int>>();
        //decalre ANS
        DFS(ans,new List<int>(),0,nums);
        // CALL DFS
        return ans;
    }

    public void DFS(IList<IList<int>> ans,List<int> current,int idx,int[] nums)
    {

        
        
        //base condition return
        if(idx==nums.Length)
        {
            ans.Add(new List<int>(current));
            return;
        }

        

        DFS(ans,new List<int>(current),idx+1,nums);

        var includedList=new List<int>(current);
        includedList.Add(nums[idx]);

        DFS(ans,includedList,idx+1,nums);

    }

}