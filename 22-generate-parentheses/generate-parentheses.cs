public class Solution {

    public IList<string> GenerateParenthesis(int n) {
        List<string> ans=new();
        Stack<char> stc=new();
        backtrack(n,0,0,ans,stc);
        return ans;
    }

    public void backtrack(int n,int opened,int closed,List<string> ans,Stack<char> stc)
    {
        if(opened==n && opened==closed)
        {
            ans.Add(new string(stc.Reverse().ToArray()));
        }

        if(opened<n)
        {
            stc.Push('(');
            backtrack(n,opened+1,closed,ans,stc);
            stc.Pop();
        }
        if(closed<opened)
        {
            stc.Push(')');
            backtrack(n,opened,closed+1,ans,stc);
            stc.Pop();
        }
    }
}