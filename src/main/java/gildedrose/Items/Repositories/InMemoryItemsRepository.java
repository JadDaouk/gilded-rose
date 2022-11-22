package gildedrose.Items.Repositories;

import gildedrose.Items.*;

import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemRepository {

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryItemsRepository() {
        items.add(new GenericItem("Generic", 5, 8, 10));
        items.add(new GenericItem("Generic", 0, 8, 10));
        items.add(new GenericItem("Generic", 5, 0, 10));
        items.add(new AggingItem("Aged Brie", 5, 5, 10));
        items.add(new AggingItem("Aged Brie", 5, 50, 10));
        items.add(new LegendaryItem("Sulfuras", 5, 80, 10));
        items.add(new EventItem("Backstage passes", 15, 10, 10));
        items.add(new EventItem("Backstage passes", 10, 10, 10));
        items.add(new EventItem("Backstage passes", 5, 10, 10));
        items.add(new EventItem("Backstage passes", 0, 10, 10));
        items.add(new ConjuredItem("Generic Conjured", 5, 10, 10));
        items.add(new ConjuredItem("Generic Conjured", 0, 10, 10));
        items.add(new GenericItem("Generic to Sell", 5, 8, 10));
    }

    public ArrayList<Item> getInventory() {
        return this.items;
    }

    public void saveInventory(ArrayList<Item> items) {
        this.items = items;
    }

    public Item findItem(String type, int quality) {
        for (Item item : items) {
            if (item.name.equals(type) && item.quality == quality) {
                return item;
            }
        }
        return null;
    }
}

