package gildedrose.shop;

import com.sun.tools.javac.util.Assert;
import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.output.ShopFakeConsoleView;
import gildedrose.shop.input.SellItemRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopTest {

    ShopInteractor shopInteractor;
    InMemoryItemsRepository repository;


    @BeforeEach
    void setup() {

        repository = new InMemoryItemsRepository();
        shopInteractor = new ShopInteractor(repository, new ShopFakeConsoleView(), null);
        shopInteractor.updateInventory();
    }

    @Test
    void should_UpdateItemEveryDay() {
        Assert.check(repository.getInventory().get(0).getSellIn() == 4);
        Assert.check(repository.getInventory().get(0).getQuality() == 7);
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        Assert.check(repository.getInventory().get(1).getQuality() == 6);
    }

    @Test
    void should_NotHaveNegativeQuality() {
        Assert.check(repository.getInventory().get(2).getQuality() == 0);
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        Assert.check(repository.getInventory().get(3).getQuality() == 6);
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        Assert.check(repository.getInventory().get(4).getQuality() == 50);
    }

    @Test
    void should_UpdateSulfuras() {
        Assert.check(repository.getInventory().get(5).getSellIn() == 5);
        Assert.check(repository.getInventory().get(5).getQuality() == 80);
    }

    @Test
    void should_UpdateBackStagePass() {
        Assert.check(repository.getInventory().get(6).getQuality() == 11);

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        Assert.check(repository.getInventory().get(7).getQuality() == 12);
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        Assert.check(repository.getInventory().get(8).getQuality() == 13);
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        Assert.check(repository.getInventory().get(9).getQuality() == 0);
    }

    @Test
    void should_UpdateConjured() {
        Assert.check(repository.getInventory().get(10).getQuality() == 8);
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        Assert.check(repository.getInventory().get(11).getQuality() == 6);
    }

    @Test
    void should_NotSellItemIfNotInInventory() {
        SellItemRequest sellItemRequest = new SellItemRequest("Not in Inventory", 7);
        shopInteractor.sellItem(sellItemRequest);
        Assert.check(shopInteractor.getBalance() == 50);
    }

    @Test
    void should_NotSellItemIfNotCouponQuality() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 2);
        shopInteractor.sellItem(sellItemRequest);
        Assert.check(shopInteractor.getBalance() == 50);
    }

    @Test
    void should_SellItem() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 7);
        shopInteractor.sellItem(sellItemRequest);
        Assert.check(repository.getInventory().stream().noneMatch(item -> item.getName().equals("Generic to Sell") && item.getQuality() == 7));
        Assert.check(shopInteractor.getBalance() == 60);
    }

}
