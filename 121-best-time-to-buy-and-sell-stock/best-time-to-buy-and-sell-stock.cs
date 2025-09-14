public class Solution {
    public int MaxProfit(int[] prices) {
        int profit=0;
        int min=prices[0];
        int N=prices.Length;
        for(int i=0;i<N;i++)
        {
            min=int.Min(min,prices[i]);//7,1,1,1
            profit=int.Max(profit,prices[i]-min);//0,0,4,4,6
        }
        return profit;
        //
    }
}