import java.util.Arrays;

public class App {
    private int countCombinations(int[] coins, int[][] dp, int index, int amount) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (index == 0)
            return 0;
        if (dp[index - 1][amount] != -1)
            return dp[index - 1][amount];
        int currentResult = -1;
        if (coins[index - 1] > amount)
            currentResult = countCombinations(coins, dp, index - 1, amount);
        else
            currentResult = countCombinations(coins, dp, index - 1, amount) +
                            countCombinations(coins, dp, index, amount - coins[index - 1]);
        dp[index - 1][amount] = currentResult;
        return currentResult;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int index = 0; index < coins.length; index++)
            Arrays.fill(dp[index], -1);
        return countCombinations(coins, dp, coins.length, amount);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[] amounts = {5, 3, 10, 4, 7};
        int[][] coinTests = {
            {1, 2, 5},
            {2},
            {10},
            {1, 2, 3},
            {2, 4}
        };

        for (int index = 0; index < amounts.length; index++)
            System.out.println(app.change(amounts[index], coinTests[index]));
    }
}
