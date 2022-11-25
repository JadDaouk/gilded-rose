package gildedrose.shop.input;


public interface ShopInputBoundary {
    void updateInventory();

    void sellItem(SellItemRequest sellItemRequest);

}
