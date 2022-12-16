package gildedrose.auctionHouse.input;

import gildedrose.item.Item;

public interface AuctionHouseInputBoundary {
    void startAuction(Item item);

    boolean isFinish();
}
