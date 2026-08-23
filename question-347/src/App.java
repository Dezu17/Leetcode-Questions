import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class App {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int index = 0; index < nums.length; index++)
            if (frequencies.containsKey(nums[index]))
                frequencies.put(nums[index], frequencies.get(nums[index]) + 1);
            else
                frequencies.put(nums[index], 1);
        PriorityQueue<int[]> order = new PriorityQueue<>(
                                    (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (Map.Entry<Integer, Integer> current : frequencies.entrySet()) {
            int[] currentPair = { current.getKey(), current.getValue() };
            order.add(currentPair);
        }
        int[] result = new int[k];
        for (int index = 0; index < k; index++)
            result[index] = order.poll()[0];
        return result;
    }
    public static void main(String[] args) throws Exception {
        int[] nums = { 1,1,1,2,2,3 };
        int k = 2;
        int[] result = topKFrequent(nums, k);
        for (int index = 0; index < result.length; index++)
            System.out.println(result[index]);
    }
}
