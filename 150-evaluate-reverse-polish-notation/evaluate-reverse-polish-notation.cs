public class Solution {
    public int EvalRPN(string[] tokens) {
       int N=tokens.Length;
       Stack<int> stc=new();
       
       for(int i=0;i<N;i++)
       {
            if("+-*/".IndexOf(tokens[i])==-1)
            {
                stc.Push(Convert.ToInt32(tokens[i]));
            }
            else
            {
               
                int second=stc.Pop();
                int first=stc.Pop();
                if(tokens[i]=="+")
                    stc.Push(first+second);
                else if(tokens[i]=="-")
                    stc.Push(first-second);
                else if(tokens[i]=="/")
                    stc.Push(first/second);
                else if(tokens[i]=="*")
                    stc.Push(first*second);

                
            }
            
       }
       return stc.Peek();
    }
}
