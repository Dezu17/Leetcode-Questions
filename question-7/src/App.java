public class App {
    public static int reverse(int x) {
        int result = 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = x * -1;
        }
        while (x > 9) {

            result = result * 10 + x % 10;
            x /= 10;
        }
        result = result * 10 + x;
        if (isNegative) {
            result = result * -1;
            if ((result * -1) % 10 != x)
                return 0;
        } else if (result % 10 != x)
            return 0;
        return result;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.print(reverse(x));
    }
}
