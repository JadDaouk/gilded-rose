package gildedrose;

import com.sun.tools.javac.util.Assert;
import gildedrose.Items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GildedRoseTest {

    Shop shop;


    @BeforeEach
    void setup() {
        List<Item> items = new ArrayList<>();
        items.add(new GenericItem("Generic", 5, 8));
        items.add(new GenericItem("Generic", 0, 8));
        items.add(new GenericItem("Generic", 5, 0));
        items.add(new AggingItem("Aged Brie", 5, 5));
        items.add(new AggingItem("Aged Brie", 5, 50));
        items.add(new LegendaryItem("Sulfuras", 5, 80));
        items.add(new EventItem("Backstage passes", 15, 10));
        items.add(new EventItem("Backstage passes", 10, 10));
        items.add(new EventItem("Backstage passes", 5, 10));
        items.add(new EventItem("Backstage passes", 0, 10));
        items.add(new ConjuredItem("Generic Conjured", 5, 10));
        items.add(new ConjuredItem("Generic Conjured", 0, 10));
        shop = new Shop(items);
        shop.updateQuality();
    }

    @Test
    void should_UpdateItemEveryDay() {
        Assert.check(shop.inventory.get(0).sellIn == 4);
        Assert.check(shop.inventory.get(0).quality == 7);
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        Assert.check(shop.inventory.get(1).quality == 6);
    }

    @Test
    void should_NotHaveNegativeQuality() {
        Assert.check(shop.inventory.get(2).quality == 0);
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        Assert.check(shop.inventory.get(3).quality == 6);
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        Assert.check(shop.inventory.get(4).quality == 50);
    }

    @Test
    void should_UpdateSulfuras() {
        Assert.check(shop.inventory.get(5).sellIn == 5);
        Assert.check(shop.inventory.get(5).quality == 80);
    }

    @Test
    void should_UpdateBackStagePass() {
        Assert.check(shop.inventory.get(6).quality == 11);

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        Assert.check(shop.inventory.get(7).quality == 12);
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        Assert.check(shop.inventory.get(8).quality == 13);
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        Assert.check(shop.inventory.get(9).quality == 0);
    }

    @Test
    void should_UpdateConjured() {
        Assert.check(shop.inventory.get(10).quality == 8);
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        Assert.check(shop.inventory.get(11).quality == 6);
    }
}
