package gildedrose;

import gildedrose.auctionHouse.AuctionHouseInteractor;
import gildedrose.auctionHouse.input.AuctionHouseConsoleController;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;

public class Main {

    public static void main(String[] args) {

        // shopConsoleController = new ShopConsoleController();

        //shopConsoleController.shopInteractor.updateInventory();

        //SellItemRequest sellItemRequest = new SellItemRequest("Generic", 7, 10);
        //shopConsoleController.shopInteractor.sellItem(sellItemRequest);
        //shopConsoleController.shopInteractor.sellItem(sellItemRequest);
//
        //AuctionHouseInteractor auctionHouseInteractor;
        //InMemoryItemsRepository inMemoryItemsRepository;
        //InMemoryBalanceRepository inMemoryBalanceRepository;
        ///inMemoryBalanceRepository = new InMemoryBalanceRepository();
        ///inMemoryItemsRepository = new InMemoryItemsRepository();
        //auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository);
        AuctionHouseConsoleController actionHouseConsoleController = new AuctionHouseConsoleController();
        actionHouseConsoleController.console();



    }
}
