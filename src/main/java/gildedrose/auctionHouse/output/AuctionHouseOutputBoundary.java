package gildedrose.auctionHouse.output;

import gildedrose.item.Item;

public interface AuctionHouseOutputBoundary {

    void displayStartAuction(Item auctionItem);

    void displayNewAuctionTxt();

    void displayNewAuction(double bidAmount);

    void displayBadAuction();

    void displayEndAuction(Item item, double bidAmount);
}
