import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j]) {
                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0 && (!used.contains(nums[first]) ||
                        !used.contains(nums[left]) || !used.contains(nums[right]))) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[first]);
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    result.add(pair);
                    used.add(nums[first]);
                    used.add(nums[left]);
                    used.add(nums[right]);
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> pair : result) {
            System.out.print(pair + "\n");
        }
    }
}
