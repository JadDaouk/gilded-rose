package gildedrose.auctionHouse.input;

import gildedrose.item.Item;
import gildedrose.item.SalableItem;

public interface AuctionHouseInputBoundary {

    void startAuction(SalableItem auctionItem);

    boolean isFinish();
}
