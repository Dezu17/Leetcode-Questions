import java.util.HashMap;

public class App {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int secondNumber = target - nums[index];
            if (!map.containsKey(secondNumber))
                map.put(nums[index], index);
            else
                return new int[] { map.get(secondNumber), index };
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] answer = twoSum(new int[] { 3, 2, 4 }, 6);
        System.out.println("Indices: " + answer[0] + ", " + answer[1]);
    }
}
