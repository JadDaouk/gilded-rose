package gildedrose.Items.Repositories;

import gildedrose.Items.Item;
import gildedrose.console.SellItemRequest;

import java.util.ArrayList;

public interface ItemGateway {

    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);

    Item findItem(SellItemRequest sellItemRequest);

}
