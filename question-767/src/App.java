import java.util.*;

public class App {
    public String reorganizeString(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            frequencies.put(s.charAt(index), (frequencies.containsKey(s.charAt(index)) ?
                                            frequencies.get(s.charAt(index)) : 0) + 1);
            if (frequencies.get(s.charAt(index)) > s.length() / 2 + 1)
            return "";
        }
        PriorityQueue<int[]> orderedPairs = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> current : frequencies.entrySet())
            orderedPairs.add(new int[] { current.getKey() - 'a', current.getValue() });
        StringBuilder word = new StringBuilder();
        int[] previousPair = null;
        while (!orderedPairs.isEmpty() || previousPair != null) {
            if (orderedPairs.isEmpty() && previousPair != null)
                return "";
            int[] pair = orderedPairs.remove();
            word.append((char) (pair[0] + 'a'));
            pair[1]--;
            if (previousPair != null)
                orderedPairs.add(previousPair);
            if (pair[1] != 0)
                previousPair = pair;
            else
                previousPair = null;
        }
        return word.toString();
    }

    public static void main(String[] args) throws Exception {
        App solution = new App();

        System.out.println("Input: s = \"axyy\"");
        System.out.println("Output: \"" + solution.reorganizeString("axyy") + "\"");

        System.out.println("Input: s = \"abbccdd\"");
        System.out.println("Output: \"" + solution.reorganizeString("abbccdd") + "\"");

        System.out.println("Input: s = \"ccccd\"");
        System.out.println("Output: \"" + solution.reorganizeString("ccccd") + "\"");

        System.out.println("Input: s = \"aab\"");
        System.out.println("Output: \"" + solution.reorganizeString("aab") + "\"");

        System.out.println("Input: s = \"aaab\"");
        System.out.println("Output: \"" + solution.reorganizeString("aaab") + "\"");
    }
}
