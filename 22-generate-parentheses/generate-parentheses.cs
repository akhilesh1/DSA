public class Solution {

    void recursive(string cur,int opened,int closed,List<string> ans,int n)
    {
        if(opened==closed && opened==n)
        {
            ans.Add(cur);
            return;
        }

        if(opened<n)//3,2
        {
            recursive(cur+"(",opened+1,closed,ans,n);
        }
        if(closed<opened)//3,2
        {
            recursive(cur+")",opened,closed+1,ans,n);
        }
        
    }

    public IList<string> GenerateParenthesis(int n) {
        var ans=new List<string>();
        recursive("",0,0,ans,n);
        return ans;
    }
}