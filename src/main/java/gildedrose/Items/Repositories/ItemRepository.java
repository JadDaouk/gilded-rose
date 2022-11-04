package gildedrose.Items.Repositories;

import gildedrose.Items.Item;

import java.util.ArrayList;

public interface ItemRepository {

    ArrayList<Item> GetInventory();

    void SaveInventory(ArrayList<Item> items);


}
