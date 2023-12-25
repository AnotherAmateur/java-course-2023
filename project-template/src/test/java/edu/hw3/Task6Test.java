package edu.hw3;

import edu.hw3.task6.StockMarket;
import edu.hw3.task6.UndegroundStockMarket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {
    @Test
    public void testMostValuableStock() {
        StockMarket stockMarket = new UndegroundStockMarket();
        StockMarket.Stock stock1 = new StockMarket.Stock("AAA", 1436.4);
        StockMarket.Stock stock2 = new StockMarket.Stock("BBB", 154.54);
        StockMarket.Stock stock3 = new StockMarket.Stock("ZZZ", 745.3);
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        assertEquals(stock1, stockMarket.mostValuableStock());
        stockMarket.remove(stock1);
        assertEquals(stock3, stockMarket.mostValuableStock());
    }
}
