public class App {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int index = 2; index < dp.length; index++)
            dp[index] = Math.max(dp[index - 2] + nums[index - 1], dp[index - 1]);
        return dp[dp.length - 1];
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] tests = {
            {6, 7, 1, 3, 8, 2, 4},
            {5, 3, 4, 11, 2},
            {1, 2, 3, 1},
            {2, 7, 9, 3, 1},
            {1, 1, 3, 3},
            {2, 9, 8, 3, 6}
        };

        int[] expected = {19, 16, 4, 12, 4, 16};

        for (int i = 0; i < tests.length; i++) {
            int actual = app.rob(tests[i]);
            if (actual != expected[i]) {
                throw new AssertionError(
                    "Test " + i + " failed: expected " + expected[i] + " but got " + actual +
                    " for " + java.util.Arrays.toString(tests[i])
                );
            }
            System.out.println(java.util.Arrays.toString(tests[i]) + " -> " + actual);
        }
    }
}
