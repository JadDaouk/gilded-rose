package gildedrose.auctionHouse;

import gildedrose.BalanceGateway;
import gildedrose.auctionHouse.input.AuctionHouseConsoleController;
import gildedrose.auctionHouse.output.AuctionHouseConsoleView;
import gildedrose.auctionHouse.output.AuctionHouseOutputBoundary;
import gildedrose.item.Item;
import gildedrose.auctionHouse.input.AuctionHouseInputBoundary;
import gildedrose.ItemGateway;

import java.util.Scanner;

public class AuctionHouseInteractor implements AuctionHouseInputBoundary {

    private BalanceGateway balanceGateway;
    private ItemGateway itemGateway;

    public AuctionHouseOutputBoundary auctionHouseOutputBoundary = new AuctionHouseConsoleView();
    public AuctionHouseConsoleController controller;

    private Item item;
    private static final int maxRound = 3;
    private int round = 0;
    private double bidAmount = 0;

    public AuctionHouseInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
    }

    @Override
    public void startAuction(Item auctionItem) {

        item = auctionItem;

        auctionHouseOutputBoundary.displayStartAuction(auctionItem);

        double currentPrice = auctionItem.getValue();

        while (!isFinish()) {
            do
            {
                auctionHouseOutputBoundary.displayNewAuctionTxt();
                bidAmount = controller.getBidAmount();

            }
            while (!isGoodBidAmount(currentPrice));

            auctionHouseOutputBoundary.displayNewAuction(bidAmount);
            currentPrice = bidAmount;
            round++;
        }

        auctionHouseOutputBoundary.displayEndAuction(item, bidAmount);

        itemGateway.getInventory().remove(auctionItem);
        balanceGateway.incrementBalance(currentPrice);
    }

    @Override
    public boolean isFinish() {
        return round == maxRound;
    }

    private boolean isGoodBidAmount(double currentPrice)
    {
        boolean result = false;
        if(round == 0) // La première enchère peut être au prix de l'objet vendu
            result = bidAmount >= currentPrice;
        else
            result = bidAmount > currentPrice * 1.1;

        if(!result)
        {
            auctionHouseOutputBoundary.displayBadAuction();
        }
        return result;
    }

    public double newBidAuction()
    {
        return 0;
    }

  //  //TODO: voir pour plutot créer la fonction bid dans auctionHouseOutputBoundary et gérer l'accès comme les fonctions display
  ///  @Override
  //  public void bid(double bidAmount) {
  //  }
//        double proposePrice = auctionHouseConsoleController.getProposePrice(bidAmount);
//        if (proposePrice > bidAmount) {
//            this.bidAmount = proposePrice;
//
//            auctionHouseOutputBoundary.displayNewAuction(proposePrice);
//        }
//    }

   // @Override
   // public void displayStartAuction(){
   //     auctionHouseOutputBoundary.displayStartAuction(null);
   // }
   // @Override
   // public void displayNewAuction(){
   //     auctionHouseOutputBoundary.displayNewAuction(bidAmount);
   // }
   // @Override
   // public void displayEndAuction(){
   //     auctionHouseOutputBoundary.displayEndAuction(item, bidAmount);
   // }
}
