public class Solution {
    public bool IsValid(string s) {
        int N=s.Length;
        //["()[]{}"
        //["([])"
        var pairs="()[]{}";
        Stack<char> st=new();
        for(int i=0;i<N;i++)
        {
            if((pairs.IndexOf(s[i]) & 1)==0)
            {
                st.Push(s[i]);
            }
            else
            {
                if (st.Count==0 || pairs.IndexOf(st.Peek())!=pairs.IndexOf(s[i])-1)
                    return false;
                else
                    st.Pop();
            }
        }
        return st.Count==0;
    }
}