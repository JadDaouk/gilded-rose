package gildedrose.shop.input;

import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.ShopInteractor;


public class ShopConsoleController {
    public InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();
    public InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository();
    public ShopInputBoundary shopInteractor = new ShopInteractor(inMemoryItemsRepository, inMemoryBalanceRepository);

    public void console(){

        this.shopInteractor.updateInventory();
        this.shopInteractor.displayInventory();

        SellItemRequest sellItemRequest = new SellItemRequest("Generic", 7, 10);
        this.shopInteractor.sellItem(sellItemRequest);
        this.shopInteractor.displayBalance();
    }
}
