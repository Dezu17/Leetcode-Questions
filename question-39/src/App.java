import java.util.List;
import java.util.ArrayList;

public class App {
    private boolean isValid(List<Integer> combination, int sum, int target) {
        if (sum > target)
            return false;
        if (combination.size() > 1 &&
            combination.get(combination.size() - 2) > combination.get(combination.size() - 1))
            return false;
        return true;
    }

    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> combination, int currentSum) {
        for (int index = 0; index < nums.length; index++) {
            combination.add(nums[index]);
            currentSum += nums[index];
            if (isValid(combination, currentSum, target))
                if (currentSum == target)
                    result.add(new ArrayList<>(combination));
                else
                    backtrack(nums, target, result, combination, currentSum);
            combination.remove(combination.size() - 1);
            currentSum -= nums[index];
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, result, new ArrayList<>(), 0);
        return result;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.combinationSum(new int[] { 2, 5, 6, 9 }, 9));
        System.out.println(app.combinationSum(new int[] { 3, 4, 5 }, 16));
        System.out.println(app.combinationSum(new int[] { 3 }, 5));
        System.out.println(app.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(app.combinationSum(new int[] { 2, 3, 5 }, 8));
        System.out.println(app.combinationSum(new int[] { 2 }, 3));
    }
}
