import java.util.*;

public class App {
    public int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();
        for (int index = 0; index < operations.length; index++)
            if (operations[index].equals("+")) {
                int second = points.pop();
                int first = points.pop();
                points.push(first);
                points.push(second);
                points.push(first + second);
            }
            else if (operations[index].equals("D"))
                points.push(points.peek() * 2);
            else if (operations[index].equals("C"))
                points.pop();
            else
                points.push(Integer.valueOf(operations[index]));
        int result = 0;
        while (!points.isEmpty())
            result += points.pop();
        return result;
    }

    public static void main(String[] args) throws Exception {
        testCalPoints(new String[] { "5", "2", "C", "D", "+" }, 30);
        testCalPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }, 27);
        testCalPoints(new String[] { "1", "C" }, 0);
        testCalPoints(new String[] { "1", "2", "+", "C", "5", "D" }, 18);
        testCalPoints(new String[] { "5", "D", "+", "C" }, 15);
    }

    private static void testCalPoints(String[] operations, int expected) {
        int actual = new App().calPoints(operations);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " but got " + actual);
        System.out.println("Passed: " + Arrays.toString(operations) + " -> " + actual);
    }
}
