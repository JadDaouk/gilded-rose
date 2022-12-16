package gildedrose.shop.output;


import gildedrose.shop.output.response.*;

import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ShopItemResponse> shopItemResponses);

    void displayBalance(double balance);
}
