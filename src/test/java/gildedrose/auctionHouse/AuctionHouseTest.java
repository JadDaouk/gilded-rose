package gildedrose.auctionHouse;

import com.sun.tools.javac.util.Assert;
import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.auctionHouse.input.AuctionHouseConsoleController;
import gildedrose.shop.ShopInteractor;
import gildedrose.shop.output.ShopFakeConsoleView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionHouseTest {

    ShopInteractor shopInteractor;
    InMemoryItemsRepository repository;


    @BeforeEach
    void setup() {

        repository = new InMemoryItemsRepository();
        shopInteractor = new ShopInteractor(repository, new ShopFakeConsoleView(), new AuctionHouseConsoleController());
        shopInteractor.updateInventory();
    }

    @Test
    void should_SellWithAuctionHouse() {
        SellItemRequest s = new SellItemRequest("Generic", 7);
        shopInteractor.startIAuction(s);
        Assert.check(shopInteractor.getBalance() == 86);
    }

    @Test
    void should_NotSellItemIfNotInInventoryWithAuctionHouse() {
        SellItemRequest s = new SellItemRequest("Generic", 20);
        shopInteractor.startIAuction(s);
        Assert.check(shopInteractor.getBalance() == 86);
    }
}
