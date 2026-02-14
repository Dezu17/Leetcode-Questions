public class App {
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        String longestPalindrome = "";
        for (int index = 0; index < s.length(); index++) {
            int left = index;
            int right = index + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                longestPalindrome = s.substring(left, right + 1);
            }
            left = index - 1;
            right = index + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                longestPalindrome = s.substring(left, right + 1);
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s = "bababd";
        System.out.print("Result: " + longestPalindrome(s));
    }
}
