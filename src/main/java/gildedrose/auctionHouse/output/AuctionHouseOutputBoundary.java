package gildedrose.auctionHouse.output;

import gildedrose.item.Item;
import gildedrose.item.SalableItem;

public interface AuctionHouseOutputBoundary {

    void displayStartAuction(SalableItem auctionItem);

    void displayNewAuction(double bidAmount);

    void displayEndAuction(Item item, double bidAmount);

    void displayCancelAuction();
}
