package gildedrose.auctionHouse;

import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.BeforeEach;

public class AuctionHouseTest {

    AuctionHouseInteractor auctionHouseInteractor;
    InMemoryItemsRepository inMemoryItemsRepository;
    InMemoryBalanceRepository inMemoryBalanceRepository;

    @BeforeEach
    void setup() {
        inMemoryBalanceRepository = new InMemoryBalanceRepository();
        inMemoryItemsRepository = new InMemoryItemsRepository();
        auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository);
    }

    //TODO: Write tests for AuctionHouseInteractor

}
