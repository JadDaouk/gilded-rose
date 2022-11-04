package gildedrose;

import com.sun.tools.javac.util.Assert;
import gildedrose.Items.Repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    Shop shop;
    InMemoryItemsRepository repository;


    @BeforeEach
    void setup() {

        repository = new InMemoryItemsRepository();
        shop = new Shop(repository);
        shop.updateQuality();
    }

    @Test
    void should_UpdateItemEveryDay() {
        Assert.check(repository.GetInventory().get(0).sellIn == 4);
        Assert.check(repository.GetInventory().get(0).quality == 7);
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        Assert.check(repository.GetInventory().get(1).quality == 6);
    }

    @Test
    void should_NotHaveNegativeQuality() {
        Assert.check(repository.GetInventory().get(2).quality == 0);
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        Assert.check(repository.GetInventory().get(3).quality == 6);
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        Assert.check(repository.GetInventory().get(4).quality == 50);
    }

    @Test
    void should_UpdateSulfuras() {
        Assert.check(repository.GetInventory().get(5).sellIn == 5);
        Assert.check(repository.GetInventory().get(5).quality == 80);
    }

    @Test
    void should_UpdateBackStagePass() {
        Assert.check(repository.GetInventory().get(6).quality == 11);

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        Assert.check(repository.GetInventory().get(7).quality == 12);
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        Assert.check(repository.GetInventory().get(8).quality == 13);
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        Assert.check(repository.GetInventory().get(9).quality == 0);
    }

    @Test
    void should_UpdateConjured() {
        Assert.check(repository.GetInventory().get(10).quality == 8);
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        Assert.check(repository.GetInventory().get(11).quality == 6);
    }
}
