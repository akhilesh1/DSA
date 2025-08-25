public class Solution {
    public int LongestConsecutive(int[] nums) {
        HashSet<int> set=new();
        int N=nums.Length;

        for(int i=0;i<N;i++)
        {
            set.Add(nums[i]);
        }
        int ans=0;
        foreach(int num in set)
        {
            //check if start of sequence
            if(!set.Contains(num-1))
            {
                int curNumber=num+1;
                int length=1;
                //if yes then count length
                while(set.Contains(curNumber))
                {
                    length++;
                    curNumber++;    
                }
                ans=Math.Max(ans,length);
            }
        }
        return ans;
    }
}