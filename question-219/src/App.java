import java.util.*;

public class App {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int start = 0, end = 0;
        Set<Integer> window = new HashSet<>();
        while (end < nums.length) {
            if (window.contains(nums[end]))
                return true;
            else
                window.add(nums[end]);
            if (end - start + 1 > k)
                window.remove(nums[start++]);
            end++;
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        App solution = new App();

        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
        System.out.println(solution.containsNearbyDuplicate(new int[] {2, 1, 2}, 1));
    }
}
