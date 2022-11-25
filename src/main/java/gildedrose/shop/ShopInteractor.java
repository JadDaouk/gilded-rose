package gildedrose.shop;

import gildedrose.Items.Item;
import gildedrose.Items.Repositories.ItemGateway;
import gildedrose.console.ItemResponse;
import gildedrose.console.SellItemRequest;

import java.util.ArrayList;
import java.util.List;

public class ShopInteractor implements ShopInputBoundary {

    private ItemGateway itemGateway;
    private ShopOutputBoundary shopOutputBoundary;

    public ShopInteractor(ItemGateway itemGateway, ShopOutputBoundary shopOutputBoundary) {
        this.itemGateway = itemGateway;
        this.shopOutputBoundary = shopOutputBoundary;
    }
    private int balance = 50;


    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            item.update();
        }
        itemGateway.saveInventory(items);

        convertItemAndDisplay(items);
    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item != null) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            balance += item.getValue();
            itemGateway.saveInventory(items);
        }

        shopOutputBoundary.displayBalance(balance);
    }

    private void convertItemAndDisplay(List<Item> items)
    {
        List<ItemResponse> itemsResponses = new ArrayList<>();

        for (Item i : items) {
            ItemResponse itemresponse = new ItemResponse(i.name, i.sellIn, i.quality, i.basePrice);
            itemsResponses.add(itemresponse);
        }
        shopOutputBoundary.displayInventory(itemsResponses);
    }

    public int getBalance()
    {
        return balance;
    }

}
