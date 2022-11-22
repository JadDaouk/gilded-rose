package gildedrose;

import gildedrose.Items.Repositories.InMemoryItemsRepository;

public class Main {

    public static void main(String[] args) {

        ShopInterator shop = new ShopInterator(new InMemoryItemsRepository());

        //shop.shopOutputBoundary.displayInventory();

        shop.updateInventory();

        SellItemRequest sellItemRequest = new SellItemRequest("Generic", 1);
        shop.sellItem(sellItemRequest);
    }
}
