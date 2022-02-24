class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length ; i++){
            if(prices[i] > buy){
                int profit = prices[i] - buy;
                maxProfit = Math.max(profit,maxProfit);
            }else{
                buy = prices[i];
            }
        }

        return maxProfit;

    }

}