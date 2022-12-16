package gildedrose.shop.output;

import gildedrose.shop.output.response.*;

import java.util.List;

public class ShopConsoleView implements ShopOutputBoundary {

    @Override
    public void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse, List<ShopPerishableImprovableItemResponse> shopPerishableImprovableItemResponse, List<ShopImprovableItemResponse> shopImprovableItemResponse, List<ShopSalableItemResponse> shopSalableItemResponse) {
        System.out.println(" --- Display Inventory --- ");
        shopPerishableImprovableItemResponse.forEach(item -> {
            System.out.println("_> " + item.name + ", quality: " + item.quality + ", sell in: " + item.sellIn + ", properties: attack " + item.attack + "/ defense " + item.defense);
        });
        shopPerishableItemResponse.forEach(item -> {
            System.out.println("_> " + item.name +  ", quality: " + item.quality + ", sell in: " + item.sellIn);
        });
        shopImprovableItemResponse.forEach(item -> {
            System.out.println("_> " + item.name + ", quality: " + item.quality + ", properties: attack " + item.attack + "/ defense " + item.defense);
        });
        shopSalableItemResponse.forEach(item -> {
            System.out.println("_> " + item.name +  ", quality: " + item.quality);

        });
        shopItemResponse.forEach(item -> {
            System.out.println("_> " + item.name +  ", quality: " + item.quality);

        });
    }

    @Override
    public void displayBalance(double balance) {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + balance);
    }

}
