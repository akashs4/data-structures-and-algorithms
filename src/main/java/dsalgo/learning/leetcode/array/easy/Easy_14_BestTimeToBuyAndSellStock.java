package dsalgo.learning.leetcode.array.easy;

// Problem url : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Easy_14_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;

        int maxProfit = prices[1] - prices[0];
        int currentSum = prices[1] - prices[0];

        for (int i = 2; i < n; i++) {
            int temp = prices[i] - prices[i - 1];
            currentSum = Math.max(currentSum + temp, temp);
            maxProfit = Math.max(maxProfit, currentSum);
        }

        return Math.max(maxProfit, 0);
    }
}
