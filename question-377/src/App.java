import java.util.*;

public class App {
    private int countCombinations(int[] nums, int target, int[] dp, int index) {
        if (index == target)
            return 1;
        if (index > target)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        dp[index] = 0;
        for (int current = 0; current < nums.length; current++)
            dp[index] += countCombinations(nums, target, dp, index + nums[current]);
        return dp[index];
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, -1);
        return countCombinations(nums, target, dp, 0);
    }

    public static void main(String[] args) throws Exception {
        testCombinationSum4(new int[] {1, 2, 3}, 4, 7);
        testCombinationSum4(new int[] {9}, 3, 0);
        testCombinationSum4(new int[] {3, 1, 2}, 4, 7);
        testCombinationSum4(new int[] {1}, 3, 1);
    }

    private static void testCombinationSum4(int[] nums, int target, int expected) {
        int actual = new App().combinationSum4(nums, target);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " for target " + target + ", but got " + actual);
        System.out.println("Passed: target " + target);
    }
}
