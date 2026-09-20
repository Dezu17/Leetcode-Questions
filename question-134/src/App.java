public class App {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int index = 0; index < gas.length; index++) {
            totalGas += gas[index];
            totalCost += cost[index];
        }
        if (totalGas < totalCost)
            return -1;
        totalGas = 0;
        int station = 0;
        for (int index = 0; index < gas.length; index++) {
            if (totalGas < 0) {
                totalGas = 0;
                station = index;
            }
            totalGas = totalGas + gas[index] - cost[index];
        }
        return station;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] gasCases = {
            {1, 2, 3, 4, 5},
            {2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3}
        };

        int[][] costCases = {
            {3, 4, 5, 1, 2},
            {3, 4, 3},
            {2, 2, 4, 1},
            {2, 3, 2}
        };

        for (int i = 0; i < gasCases.length; i++) {
            System.out.println(app.canCompleteCircuit(gasCases[i], costCases[i]));
        }
    }
}
