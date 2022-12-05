package gildedrose.auctionHouse.input;

import gildedrose.auctionHouse.AuctionHouseInteractor;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;

public class AuctionHouseConsoleController {
    public InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository();
    public InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();

    public AuctionHouseInteractor auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository);


    public void console(){

        //TODO: implement console

    }
}
