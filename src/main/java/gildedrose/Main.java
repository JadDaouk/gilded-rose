package gildedrose;

import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.ShopInteractor;
import gildedrose.shop.output.ShopConsoleView;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.shop.output.ShopOutputBoundary;

public class Main {

    public static void main(String[] args) {

        ShopOutputBoundary view = new ShopConsoleView();
        ShopInteractor shop = new ShopInteractor(new InMemoryItemsRepository(), view);

        //shop.shopOutputBoundary.displayInventory();

        shop.updateInventory();

        SellItemRequest sellItemRequest = new SellItemRequest("Generic", 7);
        shop.sellItem(sellItemRequest);
        shop.sellItem(sellItemRequest);
    }
}
