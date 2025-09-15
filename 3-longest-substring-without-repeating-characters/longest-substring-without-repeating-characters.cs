public class Solution {
    public int LengthOfLongestSubstring(string s) {
        //how sliding would help in creating non repeating substring
        int N=s.Length;
        int ans=1;
        int left=0;
        int right=0;
        if (N == 0) return 0;
        HashSet<char> set=new();
        //set.Add(s[0]);
        while(right<=N-1)
        {
            if(set.Contains(s[right]))
            {// not sure what to move
                set.Remove(s[left]);
                left++;
                continue;
            }
            else
            {
                set.Add(s[right]);
                ans=Math.Max(ans,set.Count);  
            }
            right++;

        }
        return ans;
    }
}