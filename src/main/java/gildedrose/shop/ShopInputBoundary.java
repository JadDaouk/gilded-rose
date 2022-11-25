package gildedrose.shop;


import gildedrose.console.SellItemRequest;

public interface ShopInputBoundary {
    void updateInventory();

    void sellItem(SellItemRequest sellItemRequest);

}
