package gildedrose;

import com.sun.tools.javac.util.Assert;
import gildedrose.Items.Repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    ShopInputBoundary shopInputBoundary;
    InMemoryItemsRepository repository;


    @BeforeEach
    void setup() {

        repository = new InMemoryItemsRepository();
        shopInputBoundary = new ShopInterator(repository); // ici
        shopInputBoundary.updateInventory();
    }

    @Test
    void should_UpdateItemEveryDay() {
        Assert.check(repository.getInventory().get(0).sellIn == 4);
        Assert.check(repository.getInventory().get(0).quality == 7);
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        Assert.check(repository.getInventory().get(1).quality == 6);
    }

    @Test
    void should_NotHaveNegativeQuality() {
        Assert.check(repository.getInventory().get(2).quality == 0);
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        Assert.check(repository.getInventory().get(3).quality == 6);
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        Assert.check(repository.getInventory().get(4).quality == 50);
    }

    @Test
    void should_UpdateSulfuras() {
        Assert.check(repository.getInventory().get(5).sellIn == 5);
        Assert.check(repository.getInventory().get(5).quality == 80);
    }

    @Test
    void should_UpdateBackStagePass() {
        Assert.check(repository.getInventory().get(6).quality == 11);

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        Assert.check(repository.getInventory().get(7).quality == 12);
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        Assert.check(repository.getInventory().get(8).quality == 13);
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        Assert.check(repository.getInventory().get(9).quality == 0);
    }

    @Test
    void should_UpdateConjured() {
        Assert.check(repository.getInventory().get(10).quality == 8);
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        Assert.check(repository.getInventory().get(11).quality == 6);
    }

    @Test
    void should_NotSellItemIfNotInInventory() {
        SellItemRequest sellItemRequest = new SellItemRequest("Not in Inventory", 7);
        shopInputBoundary.sellItem(sellItemRequest);
        Assert.check(shopInputBoundary.getBalance() == 50);
    }

    @Test
    void should_NotSellItemIfNotCouponQuality() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 2);
        shopInputBoundary.sellItem(sellItemRequest);
        Assert.check(shopInputBoundary.getBalance() == 50);
    }

    @Test
    void should_SellItem() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 7);
        shopInputBoundary.sellItem(sellItemRequest);
        Assert.check(repository.getInventory().stream().noneMatch(item -> item.name.equals("Generic to Sell") && item.quality == 7));
        Assert.check(shopInputBoundary.getBalance() == 60);
    }

}
