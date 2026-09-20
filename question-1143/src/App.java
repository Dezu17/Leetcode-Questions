import java.util.Arrays;

public class App {
    private int backtrack(String text1, String text2, int[][] dp, int m, int n) {
        if (n == -1 || m == -1)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (text1.charAt(m) == text2.charAt(n)) {
            dp[m][n] = 1 + backtrack(text1, text2, dp, m - 1, n - 1);
            return dp[m][n];
        }
        dp[m][n] = Math.max(backtrack(text1, text2, dp, m - 1, n), backtrack(text1, text2, dp, m, n - 1));
        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int index = 0; index < dp.length; index++)
            Arrays.fill(dp[index], -1);
        return backtrack(text1, text2, dp, m - 1, n - 1);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        String[][] tests = {
            {"abcde", "ace"},
            {"abc", "abc"},
            {"abc", "def"},
            {"cat", "crabt"},
            {"abcd", "abcd"},
            {"abcd", "efgh"}
        };

        for (String[] pair : tests) {
            System.out.println(app.longestCommonSubsequence(pair[0], pair[1]));
        }
    }
}
