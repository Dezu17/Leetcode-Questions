public class App {
    public static int strStr(String haystack, String needle) {
        int index = 0;
        while (index < haystack.length() - needle.length() + 1) {
            if (needle.charAt(0) == haystack.charAt(index)) {
                int current = 0;
                while (current < needle.length() && needle.charAt(current) == haystack.charAt(index + current))
                    current++;
                if (current == needle.length())
                    return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sxsadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
