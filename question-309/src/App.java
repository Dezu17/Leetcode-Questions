import java.util.Arrays;

public class App {
    private int getMaxProfit(int[] prices, int[][] dp, int bought, int index) {
        if (index >= prices.length)
            return 0;
        if (dp[bought][index] != -1)
            return dp[bought][index];
        int result = getMaxProfit(prices, dp, bought, index + 1);
        if (bought == 1)
            result = Math.max(result, getMaxProfit(prices, dp, 0, index + 2) + prices[index]);
        else
            result = Math.max(result, getMaxProfit(prices, dp, 1, index + 1) - prices[index]);
        dp[bought][index] = result;
        return result;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return getMaxProfit(prices, dp, 0, 0);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] tests = {
            {1, 2, 3, 0, 2},
            {1},
            {1, 3, 4, 0, 4}
        };

        for (int[] prices : tests)
            System.out.println(app.maxProfit(prices));
    }
}
