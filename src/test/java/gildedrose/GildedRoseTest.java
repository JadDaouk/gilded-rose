package gildedrose;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GildedRoseTest {

    Shop shop;


    @BeforeEach
    void setup() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Generic", 5, 8));
        items.add(new Item("Generic", 0, 8));
        items.add(new Item("Generic", 5, 0));
        items.add(new Item("Aged Brie", 5, 5));
        items.add(new Item("Aged Brie", 5, 50));
        items.add(new Item("Sulfuras", 5, 80));
        items.add(new Item("Backstage passes", 15, 10));
        items.add(new Item("Backstage passes", 10, 10));
        items.add(new Item("Backstage passes", 5, 10));
        items.add(new Item("Backstage passes", 0, 10));
        items.add(new Item("Generic Conjured", 5, 10));
        items.add(new Item("Generic Conjured", 0, 10));
        shop = new Shop(items);
    }

    @Test
    void should_UpdateItemEveryDay() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(0).sellIn == 4);
        Assert.check(shop.inventory.get(0).quality == 7);
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(1).quality == 6);
    }

    @Test
    void should_NotHaveNegativeQuality() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(2).quality == 0);
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(3).quality == 6);
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(4).quality == 50);
    }

    @Test
    void should_UpdateSulfuras() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(5).sellIn == 5);
        Assert.check(shop.inventory.get(5).quality == 80);
    }

    @Test
    void should_UpdateBackStagePass() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(6).quality == 11);

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(7).quality == 12);
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(8).quality == 13);
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(9).quality == 0);
    }

    @Test
    void should_UpdateConjured() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(10).quality == 8);
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        shop.updateQuality();
        Assert.check(shop.inventory.get(11).quality == 6);
    }
}
