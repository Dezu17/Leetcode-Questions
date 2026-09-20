import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    private static void backtrack(int n, List<String> result, StringBuilder pair, int left, int right) {
        for (int current = 0; current < 2; current++) {
            if (current == 0) {
                left++;
                pair.append('(');
            }
            else {
                right++;
                pair.append(')');
            }
            if (left >= right && left + right <= 2 * n)
                if (left == right && left + right == 2 * n)
                    result.add(pair.toString());
                else
                    backtrack(n, result, pair, left, right);
            pair.deleteCharAt(pair.length() - 1);
            if (current == 0)
                left--;
            else
                right--;
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    private static void testGenerateParenthesis(int n, List<String> expected) {
        List<String> actual = generateParenthesis(n);
        if (!actual.equals(expected))
            throw new AssertionError("n = " + n + ": expected " + expected + ", got " + actual);
        System.out.println("Passed: n = " + n);
    }

    public static void main(String[] args) {
        testGenerateParenthesis(1, Arrays.asList("()"));
        testGenerateParenthesis(3, Arrays.asList(
                "((()))", "(()())", "(())()", "()(())", "()()()"));
    }
}
