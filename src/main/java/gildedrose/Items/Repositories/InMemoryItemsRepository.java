package gildedrose.Items.Repositories;

import gildedrose.Items.*;

import java.util.ArrayList;

public class InMemoryItemsRepository implements ItemRepository {

    ArrayList<Item> items = new ArrayList<>();

    public InMemoryItemsRepository() {
        items.add(new GenericItem("Generic", 5, 8));
        items.add(new GenericItem("Generic", 0, 8));
        items.add(new GenericItem("Generic", 5, 0));
        items.add(new AggingItem("Aged Brie", 5, 5));
        items.add(new AggingItem("Aged Brie", 5, 50));
        items.add(new LegendaryItem("Sulfuras", 5, 80));
        items.add(new EventItem("Backstage passes", 15, 10));
        items.add(new EventItem("Backstage passes", 10, 10));
        items.add(new EventItem("Backstage passes", 5, 10));
        items.add(new EventItem("Backstage passes", 0, 10));
        items.add(new ConjuredItem("Generic Conjured", 5, 10));
        items.add(new ConjuredItem("Generic Conjured", 0, 10));
    }

    public ArrayList<Item> GetInventory() {
        return this.items;
    }

    public void SaveInventory(ArrayList<Item> items) {
        this.items = items;
    }

}

