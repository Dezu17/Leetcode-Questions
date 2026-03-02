public class App {
    public static String addBinary(String a, String b) {
        String result = "";
        int indexA = a.length() - 1, indexB = b.length() - 1, carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0 && indexB >= 0) {
                int digitA = a.charAt(indexA) - '0';
                int digitB = b.charAt(indexB) - '0';
                result = String.valueOf((carry + digitA + digitB) % 2) + result;
                carry = (carry + digitA + digitB) / 2;
            } else if (indexA >= 0) {
                int digitA = a.charAt(indexA) - '0';
                result = String.valueOf((carry + digitA) % 2) + result;
                carry = (carry + digitA) / 2;
            } else {
                int digitB = b.charAt(indexB) - '0';
                result = String.valueOf((carry + digitB) % 2) + result;
                carry = (carry + digitB) / 2;
            }
            indexA--;
            indexB--;
        }
        if (carry == 1)
            return '1' + result;
        return result;
    }

    public static void main(String[] args) {
        String a = "1", b = "0";
        System.out.println(addBinary(a, b));
    }
}
