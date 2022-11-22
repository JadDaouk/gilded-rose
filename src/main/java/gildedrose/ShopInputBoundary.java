package gildedrose;

import gildedrose.Items.Item;
import gildedrose.Items.Repositories.ItemGateway;

import java.util.ArrayList;

public class ShopInputBoundary extends ShopInterator {
    //public ItemRepository itemRepository;
    private int balance = 50;

    public ShopInputBoundary(ItemGateway itemGateway) {
        super(itemGateway);
       //this.itemRepository = itemRepository;
    }

    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            item.update();
        }
        itemGateway.saveInventory(items);
    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item != null) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            balance += item.getValue();
            itemGateway.saveInventory(items);
        }
    }

    public int getBalance() {
        return balance;
    }
}
