import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;

public class App {
    class KthLargest {
        private int k;
        private Queue<Integer> elements;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            elements = new PriorityQueue<>();
            for (int index = 0; index < nums.length; index++)
                if (elements.size() < k)
                    elements.add(nums[index]);
                else if (elements.peek() < nums[index]) {
                    elements.remove();
                    elements.add(nums[index]);
                }
        }
        
        public int add(int val) {
            if (elements.size() < k)
                elements.add(val);
            else if (elements.peek() < val) {
                elements.remove();
                elements.add(val);
            }
            return elements.peek();
        }
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        KthLargest first = app.new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(first.add(3));
        System.out.println(first.add(5));
        System.out.println(first.add(10));
        System.out.println(first.add(9));
        System.out.println(first.add(4));

        KthLargest second = app.new KthLargest(4, new int[] { 7, 7, 7, 7, 8, 3 });
        System.out.println(second.add(2));
        System.out.println(second.add(10));
        System.out.println(second.add(9));
        System.out.println(second.add(9));

        KthLargest third = app.new KthLargest(3, new int[] { 1, 2, 3, 3 });
        System.out.println(third.add(3));
        System.out.println(third.add(5));
        System.out.println(third.add(6));
        System.out.println(third.add(7));
        System.out.println(third.add(8));
    }
}
