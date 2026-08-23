import java.util.Stack;

public class MinStack {
    private Stack<Integer> numbers;
    private Stack<Integer> currentMin;
    private int min;
    public MinStack() {
        numbers = new Stack<>();
        currentMin = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        numbers.push(value);
        if (value < min)
            min = value;
        currentMin.push(min);
    }

    public void pop() {
        numbers.pop();
        currentMin.pop();
        if (currentMin.isEmpty())
            min = Integer.MAX_VALUE;
        else
            min = currentMin.peek();
    }

    public int top() {
        return numbers.peek();
    }

    public int getMin() {
        return currentMin.peek();
    }
}
