import java.util.*;

public class App {
    public int numRescueBoats(int[] people, int limit) {
	Arrays.sort(people);
	int boats = 0, currentBoat = 0, left = 0, right = people.length - 1, personCount = 0;
	while (left <= right)
	    if (people[right] + currentBoat <= limit && personCount < 2) {
            currentBoat += people[right--];
            personCount++;
        } else if (people[left] + currentBoat <= limit && personCount < 2) {
            currentBoat += people[left++];
            personCount++;
        }
        else {
            personCount = 0;
            currentBoat = 0;
            boats++;
        }
        if (currentBoat != 0)
            boats++;
        return boats;
    }

    private static void testNumRescueBoats(int[] people, int limit, int expected) {
        int actual = new App().numRescueBoats(people, limit);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " but got " + actual);
    }

    public static void main(String[] args) throws Exception {
        testNumRescueBoats(new int[] {1, 2}, 3, 1);
        testNumRescueBoats(new int[] {3, 2, 2, 1}, 3, 3);
        testNumRescueBoats(new int[] {3, 5, 3, 4}, 5, 4);
        testNumRescueBoats(new int[] {5, 1, 4, 2}, 6, 2);
        testNumRescueBoats(new int[] {1, 3, 2, 3, 2}, 3, 4);
    }
}
