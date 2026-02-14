public class App {
    public static boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        else if (x < 0 || x % 10 == 0)
            return false;
        else {
            int reversed = 0;
            while (x > reversed) {
                int digit = x % 10;
                x /= 10;
                reversed = reversed * 10 + digit;
                if (x == reversed || x == reversed / 10)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.print("Result: " + isPalindrome(121));
    }
}
