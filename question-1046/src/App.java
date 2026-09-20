import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

public class App {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> elements = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < stones.length; index++)
            elements.add(stones[index]);
        while (elements.size() > 1) {
            int firstMax = elements.remove();
            int secondMax = elements.remove();
            if (firstMax > secondMax)
                elements.add(firstMax - secondMax);
        }
        return elements.size() == 0 ? 0 : elements.remove();
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        System.out.println(app.lastStoneWeight(new int[] { 1 }));
        System.out.println(app.lastStoneWeight(new int[] { 2, 3, 6, 2, 4 }));
        System.out.println(app.lastStoneWeight(new int[] { 1, 2 }));
    }
}
