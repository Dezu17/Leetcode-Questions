import java.util.Arrays;

public class App {
    private int countWays(int[] nums, int[][] dp, int index, int target, int sum, int totalSum) {
        if (index == nums.length && sum == target)
            return 1;
        if (index >= nums.length)
            return 0;
        if (dp[index][sum + totalSum] != -1)
            return dp[index][sum + totalSum];
        dp[index][sum + totalSum] = countWays(nums, dp, index + 1, target, sum + nums[index], totalSum) +
                        countWays(nums, dp, index + 1, target, sum - nums[index], totalSum);
        return dp[index][sum + totalSum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int index = 0; index < nums.length; index++)
            totalSum += nums[index];
        int[][] dp = new int[nums.length][totalSum * 2 + 1];
        for (int index = 0; index < nums.length; index++)
            Arrays.fill(dp[index], -1);
        return countWays(nums, dp, 0, target, 0, totalSum);
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] numsTests = {
            {1, 1, 1, 1, 1},
            {1},
            {2, 2, 2}
        };
        int[] targets = {3, 1, 2};

        for (int index = 0; index < numsTests.length; index++)
            System.out.println(app.findTargetSumWays(numsTests[index], targets[index]));
    }
}
