public class App {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int index = 0; index < n; index++)
            dp[0][index] = 1;
        for (int index = 0; index < m; index++)
            dp[index][0] = 1;
        for (int row = 1; row < m; row++)
            for (int column = 1; column < n; column++)
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] tests = {
            {3, 7},
            {3, 2},
            {3, 6},
            {3, 3}
        };

        App app = new App();
        for (int[] test : tests) {
            System.out.println(app.uniquePaths(test[0], test[1]));
        }
    }
}
