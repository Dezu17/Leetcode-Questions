public class App {
    public static int[] plusOne(int[] digits) {
        int carry = 0, index = digits.length - 1;
        digits[index]++;
        while (index >= 0) {
            digits[index] += carry;
            carry = digits[index] / 10;
            digits[index] %= 10;
            index--;
        }
        if (carry == 0)
            return digits;
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        for (index = 0; index < digits.length; index++)
            result[index + 1] = digits[index];
        return result;
    }

    public static void main(String[] args) {
        int[] digits = { 1, 2, 3 };
        System.out.print(plusOne(digits));
    }
}
