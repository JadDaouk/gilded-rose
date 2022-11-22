package gildedrose;

import gildedrose.Items.Repositories.InMemoryItemsRepository;

import java.util.List;

public class ShopOutputBoundary
{

    private final ShopInputBoundary shopInputBoundary = new ShopInputBoundary(new InMemoryItemsRepository());

    public void displayInventory(List<ItemResponse> itemResponses){
        System.out.println(" --- Display Inventory --- ");
        //shop.itemRepository.getInventory().forEach(item -> System.out.println(item.name + " " + item.sellIn + " " + item.quality));
        itemResponses.forEach(item -> System.out.println(item.name + " " + item.sellIn + " " + item.quality));
    }

    public void displayBalance(int balance) {
        System.out.println(" --- Display Balance --- ");
        //System.out.println("Balance: " + shop.getBalance());
        System.out.println("Balance: " + balance);
    }

    public void updateInventory()
    {
        System.out.println(" --- Update Inventory --- ");
        shopInputBoundary.updateInventory();
    }

    public void sellItem(String type, int minimalQuality)
    {
        SellItemRequest sellItemRequest = new SellItemRequest(type, minimalQuality);
        shopInputBoundary.sellItem(sellItemRequest);
    }
}
