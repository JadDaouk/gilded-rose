package gildedrose;

import gildedrose.Items.Repositories.InMemoryItemsRepository;
import gildedrose.console.ConsoleView;
import gildedrose.console.SellItemRequest;
import gildedrose.shop.ShopInteractor;

public class Main {

    public static void main(String[] args) {

        ShopInteractor shop = new ShopInteractor(new InMemoryItemsRepository(), new ConsoleView());

        //shop.shopOutputBoundary.displayInventory();

        shop.updateInventory();

        SellItemRequest sellItemRequest = new SellItemRequest("Generic", 7);
        shop.sellItem(sellItemRequest);
        shop.sellItem(sellItemRequest);
    }
}
