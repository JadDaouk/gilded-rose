package gildedrose.shop.output;


import gildedrose.shop.output.response.*;

import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse, List<ShopPerishableImprovableItemResponse> shopPerishableImprovableItemResponse, List<ShopImprovableItemResponse> shopImprovableItemResponse, List<ShopSalableItemResponse> shopSalableItemResponse);

    void displayBalance(double balance);
}
