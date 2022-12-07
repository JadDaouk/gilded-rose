package gildedrose.shop.output;


import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ShopPerishableItemResponse> shopPerishableItemResponse, List<ShopItemResponse> shopItemResponse);

    void displayBalance(double balance);
}
