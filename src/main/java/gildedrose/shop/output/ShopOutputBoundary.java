package gildedrose.shop.output;


import gildedrose.shop.output.response.ShopImprovableItemResponse;
import gildedrose.shop.output.response.ShopItemResponse;
import gildedrose.shop.output.response.ShopPerishableImprovableItemResponse;
import gildedrose.shop.output.response.ShopPerishableItemResponse;

import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse, List<ShopPerishableImprovableItemResponse> shopPerishableImprovableItemResponse, List<ShopImprovableItemResponse> shopImprovableItemResponse);

    void displayBalance(double balance);
}
