package gildedrose;

import gildedrose.Items.Item;
import gildedrose.Items.Repositories.ItemRepository;

import java.util.ArrayList;

public class Shop
{
    public ItemRepository itemRepository;

    public Shop(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void updateQuality() {
        ArrayList<Item> items = itemRepository.GetInventory();
        for (Item item : items) {
            item.update();
        }
        itemRepository.SaveInventory(items);
    }
}
