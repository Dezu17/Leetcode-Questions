public class App {
    public static int maxProfit(int[] prices) {
        int minDay = prices[0], maxDay = prices[0], profit = 0;
        for (int index = 1; index < prices.length; index++)
            if (prices[index] < minDay) {
                if (maxDay - minDay > profit)
                    profit = maxDay - minDay;
                minDay = prices[index];
                maxDay = minDay;
            } else if (prices[index] > maxDay)
                maxDay = prices[index];
        if (maxDay - minDay > profit)
            profit = maxDay - minDay;
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        System.out.print("Result: " + maxProfit(prices));
    }
}
