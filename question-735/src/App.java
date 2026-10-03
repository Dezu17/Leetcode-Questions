import java.util.*;

public class App {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> elements = new Stack<>();
        for (int index = 0; index < asteroids.length; index++)
            if (asteroids[index] > 0 || (!elements.isEmpty() && elements.peek() < 0))
                elements.push(asteroids[index]);
            else {
                while (!elements.isEmpty() && elements.peek() > 0)
                    if (elements.peek() >= asteroids[index] * -1)
                        break;
                    else
                        elements.pop();
                if (!elements.isEmpty() && elements.peek() == asteroids[index] * -1)
                    elements.pop();
                else if (elements.isEmpty() || elements.peek() < 0)
                    elements.push(asteroids[index]);
            }
        int[] result = new int[elements.size()];
        for (int index = elements.size() - 1; index >= 0; index--)
            result[index] = elements.get(index);
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        testAsteroidCollision(new int[] { 5, 10, -5 }, new int[] { 5, 10 });
        testAsteroidCollision(new int[] { 8, -8 }, new int[] {});
        testAsteroidCollision(new int[] { 10, 2, -5 }, new int[] { 10 });
        testAsteroidCollision(new int[] { 3, 5, -6, 2, -1, 4 }, new int[] { -6, 2, 4 });
        testAsteroidCollision(new int[] { 2, 4, -4, -1 }, new int[] { 2 });
        testAsteroidCollision(new int[] { 5, 5 }, new int[] { 5, 5 });
        testAsteroidCollision(new int[] { 7, -3, 9 }, new int[] { 7, 9 });
    }

    private static void testAsteroidCollision(int[] asteroids, int[] expected) {
        int[] actual = new App().asteroidCollision(asteroids);
        if (!Arrays.equals(actual, expected))
            throw new AssertionError("Expected " + Arrays.toString(expected)
                    + " but got " + Arrays.toString(actual));
        System.out.println("Passed: " + Arrays.toString(actual));
    }
}
