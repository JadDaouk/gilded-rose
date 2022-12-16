package gildedrose.shop.output;

import gildedrose.shop.output.response.*;

import java.util.List;

public class ShopConsoleView implements ShopOutputBoundary {

    @Override
    public void displayInventory(List<ShopItemResponse> shopItemResponse) {
        System.out.println(" --- Display Inventory --- ");
        shopItemResponse.forEach(item -> System.out.println("_> " + item.name + ", quality: " + item.quality));
    }

    @Override
    public void displayBalance(double balance) {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + balance);
    }

}
