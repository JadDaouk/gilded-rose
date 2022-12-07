package gildedrose.shop.output;

import java.util.List;

public class ShopConsoleView implements ShopOutputBoundary {
    @Override
    public void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse){
        System.out.println(" --- Display Inventory --- ");
        shopPerishableItemResponse.forEach(item -> {
                System.out.println(item.name + " " + item.sellIn + " " + item.quality);
                System.out.println(item.name + " " + item.quality);
            });
        shopItemResponse.forEach(item -> {
            System.out.println(item.name + " " + item.quality);
            System.out.println(item.name + " " + item.quality);
        });
    }

    @Override
    public void displayBalance(double balance) {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + balance);
    }

}
