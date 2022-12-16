package gildedrose.auctionHouse.input;

import gildedrose.auctionHouse.AuctionHouseInteractor;
import gildedrose.auctionHouse.output.AuctionHouseConsoleView;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.SalableItem;
import gildedrose.item.repositories.InMemoryItemsRepository;

public class AuctionHouseConsoleController {
    public InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository();
    public InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();

    public AuctionHouseInteractor auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository, new AuctionHouseConsoleView());

    public void console(){

        auctionHouseInteractor.startAuction((SalableItem) inMemoryItemsRepository.getInventory().get(1));

    }

}
