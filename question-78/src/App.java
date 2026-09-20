import java.util.ArrayList;
import java.util.List;

public class App {
    private void createSubsets(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> result) {
        if (currentIndex == nums.length)
            result.add(new ArrayList<>(currentSubset));
        else {
            currentSubset.add(nums[currentIndex]);
            createSubsets(nums, currentIndex + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
            createSubsets(nums, currentIndex + 1, currentSubset, result);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
        createSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.subsets(new int[] { 1, 2, 3 }));
        System.out.println(app.subsets(new int[] { 0 }));
    }
}
