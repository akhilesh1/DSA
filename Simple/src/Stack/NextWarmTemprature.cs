/*739. Daily Temperatures
Medium

13243

328

Add to List

Share
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

hint : only need closet maximum element, single integer wont work since we need history of monotonically decreasing stack
*/
public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        int N=temperatures.Length;
        int[] ans=new int[N];
        Stack<int[]> stc=new Stack<int[]>();
        stc.Push(new int[]{temperatures[N-1],N-1});
        for(int i=N-2;i>=0;i--)
        {
            while(stc.Count>0 && stc.Peek()[0]<=temperatures[i])
            {
                stc.Pop();
            }
            if(stc.Count>0 && stc.Peek()[0]>temperatures[i])
            {
                ans[i]=stc.Peek()[1]-i;
            }
            else
                ans[i]=0;
            stc.Push(new int[]{temperatures[i],i});
        }
        return ans;
        
    }
}
