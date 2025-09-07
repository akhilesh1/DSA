public class Solution {

    //Dry run of this felt great
    public int[] DailyTemperatures(int[] temperatures) {
        int N=temperatures.Length;
        Stack<int> stc=new();
        stc.Push(N-1);
        int[] ans=new int[N];
        ans[N-1]=0;
        for(int i=N-2;i>=0;i--)
        {
            while(stc.Count>0 && temperatures[stc.Peek()]<=temperatures[i])
            {
                stc.Pop();
            }
            if(stc.Count>0 && temperatures[stc.Peek()]>temperatures[i])
                ans[i]=stc.Peek()-i;
            else
                 ans[i]=0;

            stc.Push(i);
            
        }
        return ans;
    }
}