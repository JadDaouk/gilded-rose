package gildedrose.auctionHouse.output;

import gildedrose.item.Item;

public class AuctionHouseConsoleView implements AuctionHouseOutputBoundary {

    public void displayStartAuction()
    {
        System.out.println("Début des enchères");
    }

    public void displayNewAuction(double bidAmount)
    {
        System.out.println(" propose " + bidAmount);
    }

    public void displayEndAuction(Item item, double bidAmount)
    {
        System.out.println(" remporte " + item.getName() + " pour " + bidAmount);
    }
}
