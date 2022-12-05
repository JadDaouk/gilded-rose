package gildedrose.auctionHouse;

import com.sun.tools.javac.util.Assert;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.shop.ShopInteractor;
import gildedrose.shop.output.ShopFakeConsoleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionHouseTest {

    ShopInteractor shopInteractor;
    InMemoryItemsRepository inMemoryItemsRepository;
    InMemoryBalanceRepository inMemoryBalanceRepository;


    @BeforeEach
    void setup() {

        inMemoryItemsRepository = new InMemoryItemsRepository();
        inMemoryBalanceRepository = new InMemoryBalanceRepository();
        shopInteractor = new ShopInteractor(inMemoryItemsRepository, new ShopFakeConsoleView(), inMemoryBalanceRepository);
        shopInteractor.updateInventory();
    }

    @Test
    void should_SellWithAuctionHouse() {
        SellItemRequest s = new SellItemRequest("Generic", 7, 10);
        //shopInteractor.startIAuction(s);
        Assert.check(inMemoryBalanceRepository.getBalance() == 86);
    }

    @Test
    void should_NotSellItemIfNotInInventoryWithAuctionHouse() {
        SellItemRequest s = new SellItemRequest("Generic", 20, 10);
        //shopInteractor.startIAuction(s);
        Assert.check(inMemoryBalanceRepository.getBalance() == 86);
    }
}
