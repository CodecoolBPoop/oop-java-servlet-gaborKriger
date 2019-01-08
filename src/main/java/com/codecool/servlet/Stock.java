package com.codecool.servlet;

public class Stock {

    public static ItemStore stock = new ItemStore();

    static {
        stock.add(new Item("Asus laptop", 1_600));
        stock.add(new Item("Harry Potter E-book", 50));
        stock.add(new Item("Lego", 80));
    }
}
