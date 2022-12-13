package gildedrose.shop.input;


import gildedrose.shop.input.request.SellItemRequest;

public interface ShopInputBoundary {
    void updateInventory();

    void sellItem(SellItemRequest sellItemRequest);

    void displayInventory();

    void displayBalance();

}
