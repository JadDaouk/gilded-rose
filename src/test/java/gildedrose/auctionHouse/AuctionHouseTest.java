package gildedrose.auctionHouse;

import gildedrose.auctionHouse.output.AuctionHouseConsoleView;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.GenericItem;
import gildedrose.item.Item;
import gildedrose.item.SalableItem;
import gildedrose.item.repositories.InMemoryItemsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AuctionHouseTest {

    AuctionHouseInteractor auctionHouseInteractor;
    InMemoryItemsRepository inMemoryItemsRepository;
    InMemoryBalanceRepository inMemoryBalanceRepository;

    @BeforeEach
    void setup() {
        inMemoryBalanceRepository = new InMemoryBalanceRepository();
        inMemoryItemsRepository = new InMemoryItemsRepository();
        auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository, new AuctionHouseConsoleView());
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    @Test
    void canSell() {
        auctionHouseInteractor.startAuction((SalableItem) inMemoryItemsRepository.getInventory().get(1));
        Assertions.assertEquals(13.31, round(inMemoryBalanceRepository.getBalance(), 2));
    }

    @Test
    void cantSell() {
        SalableItem salableItem = new GenericItem("Generic", 5, 800, 10, 1, 0);
        auctionHouseInteractor.startAuction(salableItem);
        Assertions.assertEquals(0, inMemoryBalanceRepository.getBalance());
    }

}
