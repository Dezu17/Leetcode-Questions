public class App {
    public static String longestCommonPrefix(String[] strs) {
        int length = 0;
        int index = 0;
        boolean stillCommon = true;
        while (stillCommon) {
            if (index < strs[0].length()) {
                char currentCharacter = strs[0].charAt(index);
                for (int currentString = 1; currentString < strs.length; currentString++)
                    if (index >= strs[currentString].length() || currentCharacter != strs[currentString].charAt(index))
                        stillCommon = false;
                if (stillCommon)
                    length++;
            } else
                stillCommon = false;
            index++;
        }
        if (length == 0)
            return "";
        else
            return strs[0].substring(0, length);
    }

    public static void main(String[] args) {
        String[] input = { "" };
        System.out.print("Result: " + longestCommonPrefix(input));
    }
}
