import java.util.*;

public class App {
    private int getMaxProduct(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = 1;
        for (int term = 1; term < n; term++)
            dp[n] = Math.max(dp[n], Math.max(term * getMaxProduct(n - term, dp), term * (n - term)));
        return dp[n];
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        return getMaxProduct(n, dp);
    }

    public static void main(String[] args) throws Exception {
        testIntegerBreak(2, 1);
        testIntegerBreak(10, 36);
        testIntegerBreak(4, 4);
        testIntegerBreak(12, 81);
        testIntegerBreak(3, 2);
    }

    private static void testIntegerBreak(int n, int expected) {
        int actual = new App().integerBreak(n);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " for " + n + ", but got " + actual);
        System.out.println("Passed: " + n);
    }
}
