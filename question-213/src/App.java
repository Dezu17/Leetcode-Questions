public class App {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int index = 2; index < dp.length - 1; index++)
            dp[index] = Math.max(dp[index - 1], dp[index - 2] + nums[index - 1]);
        int firstMax = dp[dp.length - 2];
        dp[1] = 0;
        dp[2] = nums[1];
        for (int index = 3; index < dp.length; index++)
            dp[index] = Math.max(dp[index - 1], dp[index - 2] + nums[index - 1]);
        return Math.max(firstMax, dp[dp.length - 1]);
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.rob(new int[] { 2, 3, 2 }));
        System.out.println(app.rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(app.rob(new int[] { 1, 2, 3 }));
        System.out.println(app.rob(new int[] { 3, 4, 3 }));
        System.out.println(app.rob(new int[] { 2, 9, 8, 3, 6 }));
    }
}
