package gildedrose.auctionHouse;

import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.GenericItem;
import gildedrose.item.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    @Test
    void canSell() {
        auctionHouseInteractor.startAuction(inMemoryItemsRepository.getInventory().get(1));
        Assertions.assertEquals(100, inMemoryBalanceRepository.getBalance());
    }

}
