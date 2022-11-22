package gildedrose;

import gildedrose.Items.Item;
import gildedrose.Items.Repositories.ItemRepository;

import java.util.ArrayList;

public class Shop {
    public ItemRepository itemRepository;
    private int balance = 50;

    public Shop(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void updateInventory() {
        ArrayList<Item> items = itemRepository.getInventory();
        for (Item item : items) {
            item.update();
        }
        itemRepository.saveInventory(items);
    }

    public void sellItem(String type, int quality) {
        Item item = itemRepository.findItem(type, quality);
        if (item != null) {
            ArrayList<Item> items = itemRepository.getInventory();
            items.remove(item);
            balance += item.basePrice;
            itemRepository.saveInventory(items);
        }
    }

    public int getBalance() {
        return balance;
    }
}
