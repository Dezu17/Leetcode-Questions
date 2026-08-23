import java.util.Stack;

public class App {
    private static boolean isOperand(String value) {
        if (value.equals("*") || value.equals("/") ||
            value.equals("+") || value.equals("-"))
            return true;
        return false;
    }
    private static int computeOperation(int first, int second, String operation) {
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }
        return 0;
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1)
            return Integer.valueOf(tokens[0]);
        Stack<Integer> terms = new Stack<>();
        for (int index = 0; index < tokens.length; index++)
            if (isOperand(tokens[index])) {
                int second = terms.pop();
                int first = terms.pop();
                terms.push(computeOperation(first, second, tokens[index]));
            }
            else
                terms.push(Integer.valueOf(tokens[index]));
        return terms.pop();
    }
    public static void main(String[] args) throws Exception {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
