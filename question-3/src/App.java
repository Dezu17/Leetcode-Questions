import java.util.HashMap;

public class App {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> characterVisited = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0, currentLength = 0;
        while (right < s.length()) {
            char currentCharacter = s.charAt(right);
            if (!characterVisited.containsKey(currentCharacter) || !characterVisited.get(currentCharacter)) {
                characterVisited.put(currentCharacter, true);
                currentLength++;
            } else {
                if (currentLength > maxLength)
                    maxLength = currentLength;
                boolean passedRepeatingCharacter = false;
                while (left < right && !passedRepeatingCharacter) {
                    char leftCharacter = s.charAt(left);
                    if (leftCharacter == currentCharacter)
                        passedRepeatingCharacter = true;
                    characterVisited.put(leftCharacter, false);
                    left++;
                }
                currentLength = right - left + 1;
                characterVisited.put(currentCharacter, true);
            }
            right++;
        }
        if (currentLength > maxLength)
            return currentLength;
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabdbb";
        System.out.print("Result: " + lengthOfLongestSubstring(s));
    }
}
