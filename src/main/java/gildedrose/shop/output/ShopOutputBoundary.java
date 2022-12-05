package gildedrose.shop.output;


import java.util.List;

public interface ShopOutputBoundary
{

    void displayInventory(List<ShopItemResponse> shopItemRespons);

    void displayBalance(double balance);
}
