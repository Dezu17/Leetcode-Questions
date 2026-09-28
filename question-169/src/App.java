import java.util.Map;
import java.util.HashMap;

public class App {
    public int majorityElement(int[] nums) {
        int maxCount = 0, maxElement = 0;
        Map<Integer, Integer> elements = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            elements.put(nums[index], (elements.containsKey(nums[index]) ? elements.get(nums[index]) : 0) + 1);
            if (elements.get(nums[index]) > maxCount) {
                maxCount = elements.get(nums[index]);
                maxElement = nums[index];
            }
        }
        return maxElement;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        assert app.majorityElement(new int[] { 3, 2, 3 }) == 3;
        assert app.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }) == 2;
        assert app.majorityElement(new int[] { 5, 5, 1, 1, 1, 5, 5 }) == 5;
        assert app.majorityElement(new int[] { 2, 2, 2 }) == 2;
        assert app.majorityElement(new int[] { 2 }) == 2;
    }
}
