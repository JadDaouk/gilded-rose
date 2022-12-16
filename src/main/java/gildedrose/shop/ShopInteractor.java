package gildedrose.shop;

import gildedrose.BalanceGateway;
import gildedrose.item.*;
import gildedrose.ItemGateway;
import gildedrose.shop.output.ShopConsoleView;
import gildedrose.shop.output.response.*;
import gildedrose.shop.input.request.SellItemRequest;
import gildedrose.shop.input.ShopInputBoundary;
import gildedrose.shop.output.ShopOutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ShopInteractor implements ShopInputBoundary {

    private ItemGateway itemGateway;
    private BalanceGateway balanceGateway;
    public ShopOutputBoundary shopOutputBoundary;

    public ShopInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway, ShopOutputBoundary shopOutputBoundary) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
        this.shopOutputBoundary = shopOutputBoundary;
    }


    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            if (item instanceof PerishableItem perishableItem) {
                perishableItem.update();
            } else if (item instanceof RelicItem relicItem) {
                balanceGateway.incrementBalance(relicItem.getValue());
            }
        }
        itemGateway.saveInventory(items);


    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item instanceof SalableItem salableItem) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            this.balanceGateway.incrementBalance(salableItem.getValue());
            itemGateway.saveInventory(items);
        }
    }

    public void displayInventory() {
        List<ShopItemResponse> shopItemResponses = new ArrayList<>();
        for (Item item : itemGateway.getInventory()) {
            ShopItemResponse shopItemResponse = new ShopItemResponse(item.getName(), item.getQuality());
            shopItemResponses.add(shopItemResponse);
        }
        shopOutputBoundary.displayInventory(shopItemResponses);

    }

    public void displayBalance() {
        shopOutputBoundary.displayBalance(balanceGateway.getBalance());
    }

}
