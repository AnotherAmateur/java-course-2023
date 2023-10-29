package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UndegroundStockMarket implements StockMarket {
    private PriorityQueue<Stock> stockPQ;

    public UndegroundStockMarket() {
        this.stockPQ = new PriorityQueue<>(new StockComparator());
    }

    @Override
    public void add(Stock stock) {
        stockPQ.offer(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockPQ.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockPQ.peek();
    }

    private static class StockComparator implements Comparator<Stock> {
        public int compare(Stock s1, Stock s2) {
            return s2.salePrice().compareTo(s1.salePrice());
        }
    }
}
