import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

public class App {
    public int[][] kClosest(int[][] points, int k) {
        Queue<double[]> indices = new PriorityQueue<>((a, b) -> a[0] != b[0] ?
	                                              Double.compare(a[0], b[0]) : Double.compare(a[1], b[1]));
        for (int index = 0; index < points.length; index++) {
            double distance = Math.sqrt(points[index][0] * points[index][0] + points[index][1] * points[index][1]);
	    double[] pair = { distance, (double) index };
	    indices.add(pair);
        }
        int[][] result = new int[k][2];
        for (int index = 0; index < k; index++) {
            double[] pair = indices.remove();
            result[index] = points[(int) pair[1]];
            }
        return result;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(Arrays.deepToString(app.kClosest(new int[][] { { 0, 2 }, { 2, 2 } }, 1)));
        System.out.println(Arrays.deepToString(app.kClosest(new int[][] { { 0, 2 }, { 2, 0 }, { 2, 2 } }, 2)));
        System.out.println(Arrays.deepToString(app.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));
        System.out.println(Arrays.deepToString(app.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));
    }
}
