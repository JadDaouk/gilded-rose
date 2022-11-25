package gildedrose.auctionHouse;

import gildedrose.auctionHouse.output.AuctionHouseOutputBoundary;
import gildedrose.item.Item;
import gildedrose.auctionHouse.input.AuctionHouseConsoleController;
import gildedrose.auctionHouse.input.AuctionHouseInputBoundary;
import gildedrose.ItemGateway;

public class AuctionHouseInteractor implements AuctionHouseInputBoundary {

    private AuctionHouseConsoleController auctionHouseConsoleController;
    private AuctionHouseOutputBoundary auctionHouseOutputBoundary;

    private static final int maxRound = 3;

    private int round = 0;
    private double bidAmount = 0;
    private String lastAuctionner;
    private ItemGateway itemGateway;
    private double balance = 0;

    public AuctionHouseInteractor(AuctionHouseConsoleController auctionHouseConsoleController, AuctionHouseOutputBoundary auctionHouseOutputBoundary, ItemGateway itemGateway) {
        this.auctionHouseConsoleController = auctionHouseConsoleController;
        this.auctionHouseOutputBoundary = auctionHouseOutputBoundary;
        this.itemGateway = itemGateway;
    }

    @Override
    public void startAuction(Item item) {

        auctionHouseOutputBoundary.displayStartAuction();

        double price = item.getValue();
        while (round < maxRound) {
            while (bidAmount < price) {
                bid(price);
            }
            price = bidAmount;
            round++;
        }

        auctionHouseOutputBoundary.displayEndAuction(item, price);



        itemGateway.getInventory().remove(item);
        //vente
    }

    public boolean isFinish() {
        return round == 3;
    }

    public void bid(double bidAmount) {
        double proposePrice = auctionHouseConsoleController.getProposePrice(bidAmount);
        if (proposePrice > bidAmount) {
            this.bidAmount = proposePrice;

            auctionHouseOutputBoundary.displayNewAuction(proposePrice);
        }
    }
}
