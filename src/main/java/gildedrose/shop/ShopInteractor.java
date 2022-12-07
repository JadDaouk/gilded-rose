package gildedrose.shop;

import gildedrose.BalanceGateway;
import gildedrose.item.Item;
import gildedrose.ItemGateway;
import gildedrose.item.PerishableItem;
import gildedrose.shop.output.ShopConsoleView;
import gildedrose.shop.output.ShopItemResponse;
import gildedrose.shop.output.ShopPerishableItemResponse;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.shop.input.ShopInputBoundary;
import gildedrose.shop.output.ShopOutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ShopInteractor implements ShopInputBoundary {

    private ItemGateway itemGateway;
    private BalanceGateway balanceGateway;
    public ShopOutputBoundary shopOutputBoundary = new ShopConsoleView();

    public ShopInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
    }


    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            if(item instanceof PerishableItem perishableItem) {
                perishableItem.update();
            }
        }
        itemGateway.saveInventory(items);


    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item != null) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            this.balanceGateway.incrementBalance(item.getValue());
            itemGateway.saveInventory(items);
        }
    }

    public void displayInventory(){
        List<ShopPerishableItemResponse> perishableItemsResponses = new ArrayList<>();
        List<ShopItemResponse> shopItemResponses = new ArrayList<>();
        for (Item item : itemGateway.getInventory()) {
            if(item instanceof PerishableItem perishableItem) {
                ShopPerishableItemResponse shopPerishableItemResponse = new ShopPerishableItemResponse(perishableItem.getName(), perishableItem.getSellIn(), perishableItem.getQuality(), perishableItem.getValue());
                perishableItemsResponses.add(shopPerishableItemResponse);
            }
            ShopItemResponse shopItemResponse = new ShopItemResponse(item.getName(), item.getQuality(), item.getValue());
            shopItemResponses.add(shopItemResponse);
        }
        shopOutputBoundary.displayInventory(perishableItemsResponses, shopItemResponses);
    }

    public void displayBalance(){
        shopOutputBoundary.displayBalance(balanceGateway.getBalance());
    }


}
