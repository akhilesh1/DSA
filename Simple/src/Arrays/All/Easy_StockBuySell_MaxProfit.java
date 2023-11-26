/*
You are given an array/list 'prices' where the elements of the array represent the prices of the stock
as they were yesterday and indices of the array represent minutes. 
Your task is to find and return the maximum profit you can make by buying and selling the stock.
You can buy and sell the stock only once.

Input: prices = [7,1,5,3,6,4]
Output: 7
Solution approach
|===>
keep calculating min price at every element
Keep calculating profit at every step
 */
package Arrays.All;

import java.util.ArrayList;

public class Easy_StockBuySell_MaxProfit {
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int N=prices.size();
        int profit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            minPrice=Math.min(minPrice,prices.get(i));
            profit=Math.max(profit,prices.get(i)-minPrice);
        }
        return profit;
    }
}
