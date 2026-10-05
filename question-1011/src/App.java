public class App {
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0], right = 0;
        for (int index = 0; index < weights.length; index++) {
            if (left < weights[index])
                left = weights[index];
                right += weights[index];
        }
        int maxCapacity = right;
        while (left <= right) {
            int currentCapacity = (left + right) / 2;
            int currentConvey = 0, dayCount = 0;
            for (int index = 0; index < weights.length; index++)
                if (currentConvey + weights[index] > currentCapacity) {
                    currentConvey = weights[index];
                    dayCount++;
                }
                else
                    currentConvey += weights[index];
            if (dayCount < days) {
                maxCapacity = currentCapacity;
                right = currentCapacity - 1;
            }
            else
                left = currentCapacity + 1;
        }
        return maxCapacity;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.shipWithinDays(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));
        System.out.println(app.shipWithinDays(
                new int[] { 3, 2, 2, 4, 1, 4 }, 3));
        System.out.println(app.shipWithinDays(
                new int[] { 1, 2, 3, 1, 1 }, 4));
        System.out.println(app.shipWithinDays(
                new int[] { 2, 4, 6, 1, 3, 10 }, 4));
        System.out.println(app.shipWithinDays(
                new int[] { 1, 2, 3, 4, 5 }, 5));
        System.out.println(app.shipWithinDays(
                new int[] { 1, 5, 4, 4, 2, 3 }, 3));
    }
}
