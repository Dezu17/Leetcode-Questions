public class App {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = piles[0];
        for (int index = 0; index < piles.length; index++)
            if (maxK < piles[index])
                maxK = piles[index];
        int left = 1, right = maxK;
        while (left < right) {
            int currentK = (left + right) / 2;
                int totalTime = 0;
                for (int index = 0; index < piles.length; index++)
                    totalTime += Math.ceil((double) piles[index] / currentK);
                if (totalTime <= h)
                    right = currentK;
            else
                left = currentK + 1;
        }
        return left;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.minEatingSpeed(new int[] { 1, 4, 3, 2 }, 9));
        System.out.println(app.minEatingSpeed(new int[] { 25, 10, 23, 4 }, 4));
        System.out.println(app.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
        System.out.println(app.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
        System.out.println(app.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
        System.out.println(app.minEatingSpeed(new int[] { 1000000000, 1, 1 }, 5));
    }
}
