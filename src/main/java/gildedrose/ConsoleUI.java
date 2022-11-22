package gildedrose;

import gildedrose.Items.Repositories.InMemoryItemsRepository;
import gildedrose.Shop;

public class ConsoleUI
{

    private final Shop shop = new Shop(new InMemoryItemsRepository());

    public void displayInventory(){
        System.out.println(" --- Display Inventory --- ");
        shop.itemRepository.getInventory().forEach(item -> System.out.println(item.name + " " + item.sellIn + " " + item.quality));

    }

    public void displayBalance() {
        System.out.println(" --- Display Balance --- ");
        System.out.println("Balance: " + shop.getBalance());
    }

    public void updateInventory()
    {
        System.out.println(" --- Update Inventory --- ");
        shop.updateInventory();
    }

    public void sellItem(String type, int minimalQuality)
    {
        shop.sellItem(type, minimalQuality);
    }
}
