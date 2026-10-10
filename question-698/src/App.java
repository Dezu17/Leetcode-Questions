import java.util.Arrays;

public class App {
    private boolean backtrack(int[] nums, int[] sums, int currentIndex) {
        if (currentIndex == nums.length) {
            for (int index = 1; index < sums.length; index++)
            if (sums[0] != sums[index])
                return false;
            return true;
        }
        boolean result = false;
        for (int index = 0; index < sums.length; index++) {
            sums[index] += nums[currentIndex];
            result = result || backtrack(nums, sums, currentIndex + 1);
            sums[index] -= nums[currentIndex];
        }
        return result;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] sums = new int[k];
        Arrays.fill(sums, 0);
        return backtrack(nums, sums, 0);
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[] example1 = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(app.canPartitionKSubsets(example1, 4));

        int[] example2 = {1, 2, 3, 4};
        System.out.println(app.canPartitionKSubsets(example2, 3));

        int[] example3 = {2, 4, 1, 3, 5};
        System.out.println(app.canPartitionKSubsets(example3, 3));
    }
}
