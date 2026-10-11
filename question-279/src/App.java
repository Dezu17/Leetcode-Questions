import java.util.*;

public class App {
    private int getMinSquareCount(int target, int[] dp, int sum) {
        if (sum == target)
            return 0;
        if (sum > target)
            return target;
        if (dp[sum] != -1)
            return dp[sum];
        int minimum = target;
        for (int current = 1; current * current <= target; current++)
            minimum = Math.min(minimum, getMinSquareCount(target, dp, sum + current * current) + 1);
        dp[sum] = minimum;
        return dp[sum];
    }

    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMinSquareCount(n, dp, 0);
    }

    public static void main(String[] args) throws Exception {
        testNumSquares(12, 3);
        testNumSquares(13, 2);
        testNumSquares(6, 3);
    }

    private static void testNumSquares(int n, int expected) {
        int actual = new App().numSquares(n);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " for " + n + ", but got " + actual);
        System.out.println("Passed: " + n);
    }
}
