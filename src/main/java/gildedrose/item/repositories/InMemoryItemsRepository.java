package gildedrose.item.repositories;

import gildedrose.ItemGateway;
import gildedrose.item.*;
import gildedrose.shop.input.SellItemRequest;

import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemGateway {

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

    public Item findItem(SellItemRequest sellItemRequest) {
        for (Item item : items) {
            if (item.getName().equals(sellItemRequest.getType()) && item.getQuality() == sellItemRequest.getQuality()) {
                return item;
            }
        }
        return null;
    }
}

