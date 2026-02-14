import java.util.HashMap;

public class App {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result = 0;
        int index = 0;
        while (index < s.length()) {
            char currentCharacter = s.charAt(index);
            if (index + 1 < s.length()) {
                char nextCharacter = s.charAt(index + 1);
                if (romanMap.get(currentCharacter) < romanMap.get(nextCharacter)) {
                    result += romanMap.get(nextCharacter) - romanMap.get(currentCharacter);
                    index += 2;
                    continue;
                }
            }
            result += romanMap.get(currentCharacter);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMXCIV";
        System.out.println("Result: " + romanToInt(romanNumeral));
    }
}
