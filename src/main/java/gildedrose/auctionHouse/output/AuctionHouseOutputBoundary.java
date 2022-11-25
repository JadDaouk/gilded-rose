package gildedrose.auctionHouse.output;

import gildedrose.item.Item;

public interface AuctionHouseOutputBoundary {

    void displayStartAuction();

    void displayNewAuction(double bidAmount);

    void displayEndAuction(Item item, double bidAmount);
}
