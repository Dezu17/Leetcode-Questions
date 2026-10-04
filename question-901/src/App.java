import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}

class StockSpanner {
    Stack<int[]> prices;

    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
	    int count = 1;
	    while (!prices.isEmpty() && prices.peek()[0] <= price)
	        count += prices.pop()[1];
	    prices.push(new int[] {price, count});
	    return count;
    }
}