public class App {
    private boolean checkRemainingPalindrome(String s, int start, int end) {
        while (start < end)
            if (s.charAt(start) != s.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        return true;
    }

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean skipped = false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return checkRemainingPalindrome(s, start + 1, end) ||
                        checkRemainingPalindrome(s, start, end - 1);
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        App solution = new App();
        String[] inputs = { "aba", "abca", "abc", "aca", "abbadc", "abbda", "a" };
        boolean[] expected = { true, true, false, true, false, true, true };

        for (int index = 0; index < inputs.length; index++) {
            boolean actual = solution.validPalindrome(inputs[index]);
            System.out.printf(
                    "s = \"%s\" | expected: %b | actual: %b | %s%n",
                    inputs[index], expected[index], actual,
                    actual == expected[index] ? "PASS" : "FAIL");
        }
    }
}
