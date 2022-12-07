package gildedrose.shop;

import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.PerishableItem;
import gildedrose.item.repositories.InMemoryItemsRepository;
import gildedrose.shop.input.SellItemRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShopTest {

    ShopInteractor shopInteractor;
    InMemoryItemsRepository inMemoryItemsRepository;
    InMemoryBalanceRepository inMemoryBalanceRepository;


    @BeforeEach
    void setup() {

        inMemoryItemsRepository = new InMemoryItemsRepository();
        inMemoryBalanceRepository = new InMemoryBalanceRepository();
        shopInteractor = new ShopInteractor(inMemoryItemsRepository, inMemoryBalanceRepository);
        shopInteractor.updateInventory();
    }

    @Test
    void should_UpdateItemEveryDay() {
        if (inMemoryItemsRepository.getInventory().get(0) instanceof PerishableItem perishableItem)
        {
            Assertions.assertEquals(4, perishableItem.getSellIn());
        }
        //todo: peut etre faire un assert pour LegendaryItem (pas de mise à jour)
        Assertions.assertEquals(7, inMemoryItemsRepository.getInventory().get(0).getQuality());
    }

    @Test
    void should_DecreaseQualityTwiceAsFastAfterSellIn() {
        Assertions.assertEquals(6, inMemoryItemsRepository.getInventory().get(1).getQuality());
    }

    @Test
    void should_NotHaveNegativeQuality() {
        Assertions.assertEquals(0, inMemoryItemsRepository.getInventory().get(2).getQuality());
    }

    @Test
    void should_IncreaseAgedBrieQuality() {
        Assertions.assertEquals(6, inMemoryItemsRepository.getInventory().get(3).getQuality());
    }

    @Test
    void should_NotHaveQualityOverFifty() {
        Assertions.assertEquals(50, inMemoryItemsRepository.getInventory().get(4).getQuality());
    }

    @Test
    void should_UpdateSulfuras() {
        if (inMemoryItemsRepository.getInventory().get(5) instanceof PerishableItem perishableItem)
        {
            Assertions.assertEquals(5, perishableItem.getSellIn());
        }
        //todo: peut etre faire un assert pour LegendaryItem (pas de mise à jour)
        Assertions.assertEquals(80, inMemoryItemsRepository.getInventory().get(5).getQuality());
    }

    @Test
    void should_UpdateBackStagePass() {
        Assertions.assertEquals(11, inMemoryItemsRepository.getInventory().get(6).getQuality());

    }

    @Test
    void should_UpdateBackStagePassTenDaysBefore() {
        Assertions.assertEquals(12, inMemoryItemsRepository.getInventory().get(7).getQuality());
    }

    @Test
    void should_UpdateBackStagePassFiveDaysBefore() {
        Assertions.assertEquals(13, inMemoryItemsRepository.getInventory().get(8).getQuality());
    }

    @Test
    void should_UpdateBackStagePassAfterConcert() {
        Assertions.assertEquals(0, inMemoryItemsRepository.getInventory().get(9).getQuality());
    }

    @Test
    void should_UpdateConjured() {
        Assertions.assertEquals(8, inMemoryItemsRepository.getInventory().get(10).getQuality());
    }

    @Test
    void should_UpdateConjuredAfterSellIn() {
        Assertions.assertEquals(6, inMemoryItemsRepository.getInventory().get(11).getQuality());
    }

    @Test
    void should_NotSellItemIfNotInInventory() {
        SellItemRequest sellItemRequest = new SellItemRequest("Not in Inventory", 7, 10);
        shopInteractor.sellItem(sellItemRequest);
        Assertions.assertEquals(0, inMemoryBalanceRepository.getBalance());
    }

    @Test
    void should_NotSellItemIfNotCouponQuality() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 2, 10);
        shopInteractor.sellItem(sellItemRequest);
        Assertions.assertEquals(0, inMemoryBalanceRepository.getBalance());
    }

    @Test
    void should_SellItem() {
        SellItemRequest sellItemRequest = new SellItemRequest("Generic to Sell", 7, 10);
        shopInteractor.sellItem(sellItemRequest);
        Assertions.assertEquals(10, inMemoryBalanceRepository.getBalance());
        Assertions.assertTrue(inMemoryItemsRepository.getInventory().stream().noneMatch(item -> item.getName().equals("Generic to Sell") && item.getQuality() == 7));
    }

}
