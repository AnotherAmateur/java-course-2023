package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UndegroundStockMarket implements StockMarket {
    private final PriorityQueue<Stock> stockPQ;

    public UndegroundStockMarket() {
        this.stockPQ = new PriorityQueue<>(COAST_COMPARATOR_DESC);
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

    private static final Comparator<Stock> COAST_COMPARATOR_DESC = Comparator
        .comparingDouble(Stock::salePrice)
        .reversed();
}
