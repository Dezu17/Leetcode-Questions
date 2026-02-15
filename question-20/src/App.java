import java.util.Stack;

public class App {
    public static boolean isValid(String s) {
        if (s.length() < 2)
            return false;
        Stack<Character> brackets =  new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char current = s.charAt(index);
            if (current == '(' || current == '[' || current == '{')
                brackets.push(current);
            else if (!brackets.empty()) {
                char popped = brackets.pop();
                if (current == ')' && popped != '(')
                    return false;
                else if (current == ']' && popped != '[')
                    return false;
                else if (current == '}' && popped != '{')
                    return false;
            }
        }
        if (!brackets.empty())
            return false;
        return true;
    }
    public static void main(String[] args) {
        String s = "]";
        System.out.print("Result: " + isValid(s));
    }
}