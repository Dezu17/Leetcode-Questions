import java.util.*;

public class App {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> elements = new PriorityQueue<>((a, b) -> a[1] == b[1] ?
							                                a[2] - b[2] : a[1] - b[1]);
	    for (int index = 0; index < trips.length; index++)
	        elements.add(trips[index]);
        PriorityQueue<int[]> previousPickups = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currentCapacity = 0;
        while (!elements.isEmpty()) {
	        int[] currentElement = elements.remove();
                while (!previousPickups.isEmpty() && previousPickups.peek()[2] <= currentElement[1])
                    currentCapacity -= previousPickups.remove()[0];
            currentCapacity += currentElement[0];
            previousPickups.add(currentElement);
            if (currentCapacity > capacity)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.carPooling(new int[][] { { 4, 1, 2 }, { 3, 2, 4 } }, 4));
        System.out.println(app.carPooling(new int[][] { { 2, 1, 3 }, { 3, 2, 4 } }, 4));
        System.out.println(app.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
        System.out.println(app.carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));
        System.out.println(app.carPooling(
                new int[][] { { 9, 3, 4 }, { 9, 1, 7 }, { 4, 2, 4 }, { 7, 4, 5 } }, 23));
    }
}
