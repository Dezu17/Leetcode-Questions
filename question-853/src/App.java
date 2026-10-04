import java.util.*;

public class App {
    private int partition(int[] position, int[] speed, int left, int right) {
        int pivot = position[right];
        int pivotIndex = left - 1;
        for (int index = left; index < right; index++)
            if (position[index] < pivot) {
                pivotIndex++;
                int auxPosition = position[index];
                int auxSpeed = speed[index];
                position[index] = position[pivotIndex];
                speed[index] = speed[pivotIndex];
                position[pivotIndex] = auxPosition;
                speed[pivotIndex] = auxSpeed;
            }
        pivotIndex++;
        int auxPosition = position[right];
        int auxSpeed = speed[right];
        position[right] = position[pivotIndex];
        speed[right] = speed[pivotIndex];
        position[pivotIndex] = auxPosition;
        speed[pivotIndex] = auxSpeed;
        return pivotIndex;
    }

    private void quickSort(int[] position, int[] speed, int left, int right) {
        if (left < right) {
            int pivot = partition(position, speed, left, right);
            quickSort(position, speed, left, pivot - 1);
            quickSort(position, speed, pivot + 1, right);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        quickSort(position, speed, 0, position.length - 1);
        Stack<Double> remainingTimes = new Stack<>();
        for (int index = 0; index < position.length; index++) {
            double remainingTime = (double) (target - position[index]) / speed[index];
            while (!remainingTimes.isEmpty() && remainingTimes.peek() <= remainingTime)
                remainingTimes.pop();
            remainingTimes.push(remainingTime);
        }
        return remainingTimes.size();
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }));
        System.out.println(app.carFleet(10, new int[] { 3 }, new int[] { 3 }));
        System.out.println(app.carFleet(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }));
        System.out.println(app.carFleet(10, new int[] { 1, 4 }, new int[] { 3, 2 }));
        System.out.println(app.carFleet(10, new int[] { 4, 1, 0, 7 }, new int[] { 2, 2, 1, 1 }));
    }
}
