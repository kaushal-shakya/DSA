package leetcode.arrays;

public class BuySellStock {

    public static void main(String[] args) {
        int[] input = {2,4,1};
        System.out.println(maxProfit(input));

    }
    public static int maxProfit(int[] prices) {

        int buyprice = Integer.MAX_VALUE;
        int sellprice = Integer.MIN_VALUE;
        int profit = -1;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < buyprice){
                buyprice = prices[i];
                sellprice = prices[i];
            }else if(prices[i] > sellprice){
                sellprice = prices[i];
            }

            System.out.println("Current Price @" +prices[i] +" Buy @"+buyprice+ " " + " Sell @"+sellprice);
        }
        return sellprice-buyprice;
    }
}
