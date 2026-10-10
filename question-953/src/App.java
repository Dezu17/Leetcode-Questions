import java.util.*;

public class App {
    private int compareStrings(Map<Character, Integer> positions, String a, String b) {
        int index = 0;
        while (index < a.length() && index < b.length())
            if (positions.get(a.charAt(index)) < positions.get(b.charAt(index)))
                return -1;
            else if (positions.get(a.charAt(index)) > positions.get(b.charAt(index)))
                return 1;
            else
                index++;
        if (index < a.length())
            return 1;
        if (index < b.length())
            return -1;
        return 0;
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> positions = new HashMap<>();
        for (int index = 0; index < order.length(); index++)
            positions.put(order.charAt(index), index);
        for (int index = 0; index < words.length - 1; index++)
            if (compareStrings(positions, words[index], words[index + 1]) > 0)
                return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        String[] example1 = {"hello", "leetcode"};
        System.out.println(app.isAlienSorted(example1, "hlabcdefgijkmnopqrstuvwxyz"));

        String[] example2 = {"word", "world", "row"};
        System.out.println(app.isAlienSorted(example2, "worldabcefghijkmnpqstuvxyz"));

        String[] example3 = {"apple", "app"};
        System.out.println(app.isAlienSorted(example3, "abcdefghijklmnopqrstuvwxyz"));

        String[] example4 = {"dag", "disk", "dog"};
        System.out.println(app.isAlienSorted(example4, "hlabcdefgijkmnopqrstuvwxyz"));

        String[] example5 = {"neetcode", "neet"};
        System.out.println(app.isAlienSorted(example5, "worldabcefghijkmnpqstuvxyz"));
    }
}
