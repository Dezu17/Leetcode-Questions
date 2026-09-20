import java.util.Arrays;

public class App {
    private boolean backtrack(int[] nums, int[][] dp, int index, int sum) {
        if (sum == 0)
            return true;
        if (sum < 0)
            return false;
        if (index <= 0)
            return false;
        if (dp[index - 1][sum] == 1)
            return true;
        else if (dp[index - 1][sum] == 0)	
            return false;
        if (backtrack(nums, dp, index - 1, sum - nums[index - 1]) || backtrack(nums, dp, index - 1, sum))
            dp[index - 1][sum] = 1;
        else
            dp[index - 1][sum] = 0;
        if (dp[index - 1][sum] == 1)
            return true;
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int index = 0; index < nums.length; index++)
            sum += nums[index];
        if (sum % 2 == 1)
            return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int index = 0; index < nums.length; index++)
            Arrays.fill(dp[index], -1);
        return backtrack(nums, dp, nums.length, sum / 2);
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] numsTests = {
            {1, 5, 11, 5},
            {1, 2, 3, 5},
            {1, 2, 3, 4},
            {1, 2, 3, 4, 5}
        };

        int[][] arrTests = {
            {1, 5, 11, 5},
            {1},
            {2}
        };

        for (int[] nums : numsTests)
            System.out.println(app.canPartition(nums));
        for (int[] arr : arrTests)
            System.out.println(app.canPartition(arr));
    }
}
