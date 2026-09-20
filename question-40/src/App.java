import java.util.List;
import java.util.ArrayList;

public class App {
    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> combination, int sum, int startIndex) {
        for (int index = startIndex; index < nums.length; index++) {
            if (index == startIndex ||
                (index > startIndex && nums[index] != nums[index - 1])) {
                combination.add(nums[index]);
                sum += nums[index];
                if (sum <= target)
                    if (sum == target)
                        result.add(new ArrayList<>(combination));
                    else
                        backtrack(nums, target, result, combination, sum, index + 1);
                combination.remove(combination.size() - 1);
                sum -= nums[index];
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < candidates.length; first++)
            for (int second = first + 1; second < candidates.length; second++)
                if (candidates[first] > candidates[second]) {
                    int aux = candidates[first];
                    candidates[first] = candidates[second];
                    candidates[second] = aux;
                }
        backtrack(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        System.out.println(app.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
        System.out.println(app.combinationSum2(new int[] { 1, 2, 3, 4, 5 }, 7));
        System.out.println(app.combinationSum2(new int[] { 9, 2, 2, 4, 6, 1, 5 }, 8));
        System.out.println(app.combinationSum2(new int[] { 3 }, 8));
    }
}
