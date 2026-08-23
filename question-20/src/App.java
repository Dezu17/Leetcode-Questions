import java.util.Stack;

public class App {
    private static boolean isOpenBracket(char character) {
        if (character == '(' || character == '[' || character == '{')
            return true;
        return false;
    }
    private static boolean isValidPair(char first, char second) {
        if (first == '(' && second == ')')
            return true;
        if (first == '[' && second == ']')
            return true;
        if (first == '{' && second == '}')
            return true;
        return false;
    }
    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int index = 0; index < s.length(); index++)
            if (isOpenBracket(s.charAt(index)))
                brackets.push(s.charAt(index));
            else if (!brackets.isEmpty()) {
                char popped = brackets.pop();
                if (!isValidPair(popped, s.charAt(index)))
                    return false;
            }
            else
                return false;
        if (!brackets.isEmpty())
            return false;
        return true;
    }
    public static void main(String[] args) {
        String s = "{}}";
        System.out.print("Result: " + isValid(s));
    }
}