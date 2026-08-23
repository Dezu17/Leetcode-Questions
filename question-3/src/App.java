import java.util.HashSet;

public class App {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashSet<Character> visited = new HashSet<>();
        visited.add(s.charAt(0));
        int maxLength = 0;
        int startIndex = 0, endIndex = 1;
        while (endIndex < s.length()) {
            char currentCharacter = s.charAt(endIndex);
            if (visited.contains(currentCharacter)) {
                if (maxLength < endIndex - startIndex)
                    maxLength = endIndex - startIndex;
                while (s.charAt(startIndex) != currentCharacter) {
                    visited.remove(s.charAt(startIndex));
                    startIndex++;
                }
                startIndex++;
            }
            else
                visited.add(currentCharacter);
            endIndex++;
        }
        if (maxLength < endIndex - startIndex)
                    maxLength = endIndex - startIndex;
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.print("Result: " + lengthOfLongestSubstring(s));
    }
}
