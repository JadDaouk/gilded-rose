package gildedrose.item.repositories;

import gildedrose.ItemGateway;
import gildedrose.item.Item;
import gildedrose.shop.input.SellItemRequest;

import java.util.ArrayList;

public class FileItemsRepository implements ItemGateway {

    public ArrayList<Item> getInventory() {
        return null;
    }

    public void saveInventory(ArrayList<Item> items) {

    }

    public Item findItem(SellItemRequest sellItemRequest) {
        return null;
    }

}

