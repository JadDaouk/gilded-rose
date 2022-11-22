package gildedrose.Items.Repositories;

import gildedrose.Items.Item;

import java.util.ArrayList;

public interface ItemRepository {

    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);

    Item findItem(String type, int quality);

}
