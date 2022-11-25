package gildedrose.shop;


import gildedrose.console.ItemResponse;

import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ItemResponse> itemResponses);

    void displayBalance(int balance);
}
