package gildedrose;

import gildedrose.Items.Item;
import gildedrose.Items.Repositories.ItemGateway;

import java.util.ArrayList;
import java.util.List;

public abstract class ShopInputBoundary {

    protected ShopOutputBoundary shopOutputBoundary = new ConsoleView();

    public ItemGateway itemGateway;
    private int balance = 50;

    public ShopInputBoundary(ItemGateway itemGateway) {

       this.itemGateway = itemGateway;
    }

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
        List<ItemResponse> itemsResponses = new ArrayList<ItemResponse>();

        for (Item i : items) {
            ItemResponse itemresponse = new ItemResponse(i.name, i.sellIn, i.quality, i.basePrice);
            itemsResponses.add(itemresponse);
        }
        shopOutputBoundary.displayInventory(itemsResponses);
    }
    public int getBalance() {
        return balance;
    }
}
