package gildedrose.console;

import gildedrose.shop.ShopOutputBoundary;

import java.util.List;

public class ConsoleView implements ShopOutputBoundary {

    public void displayInventory(List<ItemResponse> itemResponses){
        System.out.println(" --- Display Inventory --- ");
        itemResponses.forEach(item -> System.out.println(item.name + " " + item.sellIn + " " + item.quality));
    }

    public void displayBalance(int balance) {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + balance);
    }}
