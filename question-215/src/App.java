import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

public class App {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> elements = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < nums.length; index++)
            elements.add(nums[index]);
        int result = 0;
        for (int count = 0; count < k; count++)
            result = elements.remove();
        return result;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(app.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
        System.out.println(app.findKthLargest(new int[] { 2, 3, 1, 5, 4 }, 2));
        System.out.println(app.findKthLargest(new int[] { 2, 3, 1, 1, 5, 5, 4 }, 3));
    }
}
