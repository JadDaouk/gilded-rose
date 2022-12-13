package gildedrose.auctionHouse.output;

import gildedrose.item.Item;

public class AuctionHouseConsoleView implements AuctionHouseOutputBoundary {

    public void displayStartAuction(Item auctionItem)
    {

        System.out.println("Début des enchères");
        System.out.println("Article proposé : " + auctionItem.getName() + " pour le prix initial de " + auctionItem.getValue());
    }

    public void displayNewAuctionTxt() {System.out.println("Nouvelle enchère ?");}

    public void displayNewAuction(double bidAmount)
    {
        System.out.println("Nouvelle enchère de " + bidAmount + " !");
    }

    public void displayBadAuction()
    {
        System.out.println("L'enchère n'est pas valide");
    }
    public void displayEndAuction(Item item, double bidAmount)
    {
        System.out.println(item.getName() + " vendu pour " + bidAmount + " !");
    }
}
