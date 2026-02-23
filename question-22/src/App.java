import java.util.*;

public class App {
    public static List<String> result;

    private static boolean isValid(String s, int n) {
        if (s.length() <= n * 2)
            return true;
        return false;
    }

    private static boolean isSolution(String s, int n) {
        if (s.length() != n * 2)
            return false;
        Stack<Character> parentheses = new Stack<>();
        for (int index = 0; index < n * 2; index++) {
            if (s.charAt(index) == ')') {
                if (!parentheses.isEmpty())
                    parentheses.pop();
                else
                    return false;
            } else
                parentheses.push('(');
        }
        if (parentheses.isEmpty())
            return true;
        return false;
    }

    private static List<String> createList(int n, String currentString) {
        String options = "()", copy = currentString;
        for (int index = 0; index < options.length(); index++) {
            currentString += options.charAt(index);
            if (isValid(currentString, n))
                if (isSolution(currentString, n))
                    result.add(currentString);
                else
                    createList(n, currentString);
            currentString = copy;
        }
        return result;
    }

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        return createList(n, "");
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> results = generateParenthesis(n);
        for (int index = 0; index < results.size(); index++)
            System.out.println(result.get(index));
    }
}
