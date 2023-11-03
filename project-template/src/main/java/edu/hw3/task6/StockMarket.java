package edu.hw3.task6;

public interface StockMarket {
    void add(Stock stock);

    void remove(Stock stock);

    Stock mostValuableStock();

    record Stock(String name, double salePrice) {
    }
}
