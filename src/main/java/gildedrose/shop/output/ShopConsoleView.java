package gildedrose.shop.output;

import gildedrose.shop.output.response.ShopImprovableItemResponse;
import gildedrose.shop.output.response.ShopItemResponse;
import gildedrose.shop.output.response.ShopPerishableImprovableItemResponse;
import gildedrose.shop.output.response.ShopPerishableItemResponse;

import java.util.List;

public class ShopConsoleView implements ShopOutputBoundary {

    @Override
    public void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse, List<ShopPerishableImprovableItemResponse> shopPerishableImprovableItemResponse, List<ShopImprovableItemResponse> shopImprovableItemResponse) {
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
