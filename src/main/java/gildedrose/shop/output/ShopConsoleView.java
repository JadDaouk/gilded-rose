package gildedrose.shop.output;

import java.util.List;

public class ShopConsoleView implements ShopOutputBoundary {

    public void displayInventory(List<ShopItemResponse> shopItemRespons){
        System.out.println(" --- Display Inventory --- ");
        shopItemRespons.forEach(item -> System.out.println(item.name + " " + item.sellIn + " " + item.quality));
    }

    @Override
    public void displayBalance(double balance) {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + balance);
    }

}
