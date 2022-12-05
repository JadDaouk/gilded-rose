package gildedrose.auctionHouse;

import gildedrose.BalanceGateway;
import gildedrose.auctionHouse.output.AuctionHouseConsoleView;
import gildedrose.auctionHouse.output.AuctionHouseOutputBoundary;
import gildedrose.item.Item;
import gildedrose.auctionHouse.input.AuctionHouseInputBoundary;
import gildedrose.ItemGateway;

public class AuctionHouseInteractor implements AuctionHouseInputBoundary {

    private BalanceGateway balanceGateway;
    private ItemGateway itemGateway;

    public AuctionHouseOutputBoundary auctionHouseOutputBoundary = new AuctionHouseConsoleView();

    private Item item;
    private static final int maxRound = 3;
    private int round = 0;
    private double bidAmount = 0;

    public AuctionHouseInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
    }

    @Override
    public void startAuction(Item AuctionItem) {

        item = AuctionItem;
        //auctionHouseOutputBoundary.displayStartAuction();

        double price = AuctionItem.getValue();
        while (round < maxRound) {
            while (bidAmount < price) {
                bid(price);
            }
            price = bidAmount;
            round++;
        }

        //auctionHouseOutputBoundary.displayEndAuction(item, price);

        itemGateway.getInventory().remove(AuctionItem);
        balanceGateway.incrementBalance(price);
    }

    @Override
    public boolean isFinish() {
        return round == 3;
    }

    //TODO: voir pour plutot créer la fonction bid dans auctionHouseOutputBoundary et gérer l'accès comme les fonctions display
    @Override
    public void bid(double bidAmount) {
    }
//        double proposePrice = auctionHouseConsoleController.getProposePrice(bidAmount);
//        if (proposePrice > bidAmount) {
//            this.bidAmount = proposePrice;
//
//            auctionHouseOutputBoundary.displayNewAuction(proposePrice);
//        }
//    }

    @Override
    public void displayStartAuction(){
        auctionHouseOutputBoundary.displayStartAuction();
    }
    @Override
    public void displayNewAuction(){
        auctionHouseOutputBoundary.displayNewAuction(bidAmount);
    }
    @Override
    public void displayEndAuction(){
        auctionHouseOutputBoundary.displayEndAuction(item, bidAmount);
    }
}
