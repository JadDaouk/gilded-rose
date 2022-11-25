package gildedrose;

import gildedrose.item.Item;
import gildedrose.shop.input.SellItemRequest;

import java.util.ArrayList;

public interface ItemGateway {

    ArrayList<Item> getInventory();

    void saveInventory(ArrayList<Item> items);

    Item findItem(SellItemRequest sellItemRequest);

}
