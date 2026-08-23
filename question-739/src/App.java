import java.util.Stack;

public class App {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexes = new Stack<>();
        result[result.length - 1] = 0;
        indexes.push(result.length - 1);
        for (int index = temperatures.length - 2; index >= 0; index--)
            if (temperatures[index] < temperatures[indexes.peek()]) {
                indexes.push(index);
                result[index] = 1;
            }
            else {
                while (!indexes.isEmpty() &&
                        temperatures[indexes.peek()] <= temperatures[index])
                    indexes.pop();
                if (indexes.isEmpty())
                    result[index] = 0;
                else
                    result[index] = indexes.peek() - index;
                indexes.push(index);
            }
        return result;
    }
    public static void main(String[] args) throws Exception {
        int[] result = dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        for (int index = 0; index < result.length; index++)
            System.out.print(result[index] + " ");
    }
}
