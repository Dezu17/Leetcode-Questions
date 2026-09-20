public class App {
    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        int maxLength = 1, maxStartIndex = 0;
        for (int start = 0; start < s.length(); start++)
            for (int end = start + 1; end < s.length(); end++) {
                int left = start, right = end;
                boolean isPalindrome = true;
                while (left < right && isPalindrome) {
                    if (s.charAt(left) != s.charAt(right))
                        isPalindrome = false;
                    left++;
                    right--;
                }
                if (isPalindrome && maxLength < end - start + 1) {
                    maxLength = end - start + 1;
                    maxStartIndex = start;
                }
            }
        return s.substring(maxStartIndex, maxStartIndex + maxLength);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.print("Result: " + longestPalindrome(s));
    }
}
