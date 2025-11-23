public class Solution {
    public IList<string> GenerateParenthesis(int n) {
        List<string> ans=new();
        Stack<char> stc=new();
        Backtrack(n,stc,0,0,ans);
        return ans;
    }

    void Backtrack(int n,Stack<char> stc,int opened,int closed,List<string> ans)
    {
        if(opened==n && opened==closed)
        {
            ans.Add(new String(stc.Reverse().ToArray()));
            return;
        }
        
        //options based on intelligence
        if(opened<n)
        {
            stc.Push('(');
            Backtrack(n,stc,opened+1,closed,ans);
            stc.Pop();
        }
        if(closed<opened)
        {
            stc.Push(')');
            Backtrack(n,stc,opened,closed+1,ans);
            stc.Pop();
        }

    }

   
}