package gildedrose.auctionHouse;

import gildedrose.BalanceGateway;
import gildedrose.auctionHouse.output.AuctionHouseConsoleView;
import gildedrose.auctionHouse.output.AuctionHouseOutputBoundary;
import gildedrose.item.Item;
import gildedrose.auctionHouse.input.AuctionHouseInputBoundary;
import gildedrose.ItemGateway;
import gildedrose.item.SalableItem;
import gildedrose.shop.input.request.SellItemRequest;

public class AuctionHouseInteractor implements AuctionHouseInputBoundary {

    private BalanceGateway balanceGateway;
    private ItemGateway itemGateway;

    public AuctionHouseOutputBoundary auctionHouseOutputBoundary;

    private static final int maxRound = 3;
    private int round;
    private static final double bid = 1.1;

    public AuctionHouseInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway, AuctionHouseOutputBoundary auctionHouseOutputBoundary) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
        this.auctionHouseOutputBoundary = auctionHouseOutputBoundary;
    }

    @Override
    public void startAuction(SalableItem auctionItem) {

        initAuction();
        auctionHouseOutputBoundary.displayStartAuction(auctionItem);

        if(canSell(auctionItem))
        {
            double currentPrice = auctionItem.getValue();

            while (!isFinish()) {
                currentPrice = currentPrice * bid;

                auctionHouseOutputBoundary.displayNewAuction(currentPrice);
                round++;
            }

            auctionHouseOutputBoundary.displayEndAuction(auctionItem, currentPrice);

            itemGateway.getInventory().remove(auctionItem);
            balanceGateway.incrementBalance(currentPrice);
        }
        else
        {
            auctionHouseOutputBoundary.displayCancelAuction();
        }

    }

    @Override
    public boolean isFinish() {
        return round == maxRound;
    }

    public boolean canSell(SalableItem auctionItem)
    {
        SellItemRequest sellItemRequest = new SellItemRequest(auctionItem.getName(), auctionItem.getQuality(), auctionItem.getValue());
        Item result = itemGateway.findItem(sellItemRequest);
        return result != null;
    }

    private void initAuction()
    {
        round = 0;
    }

}
