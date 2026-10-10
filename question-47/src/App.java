import java.util.*;

public class App {
    List<List<Integer>> result;

    private void backtrack(int[] nums, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (!visited[index]) {
                permutation.add(nums[index]);
                visited[index] = true;
                backtrack(nums, permutation, visited);
                visited[index] = false;
                permutation.remove(permutation.size() - 1);
                while (index + 1 < nums.length && nums[index] == nums[index + 1])
                    index++;
            }
            index++;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), visited);
        return result;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[] example1 = {1, 1, 2};
        System.out.println(app.permuteUnique(example1));

        int[] example2 = {1, 2, 3};
        System.out.println(app.permuteUnique(example2));

        int[] example3 = {2, 2};
        System.out.println(app.permuteUnique(example3));
    }
}
