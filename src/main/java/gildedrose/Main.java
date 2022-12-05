package gildedrose;

import gildedrose.shop.input.ShopConsoleController;
import gildedrose.shop.input.SellItemRequest;

public class Main {

    public static void main(String[] args) {

        ShopConsoleController shopConsoleController = new ShopConsoleController();

        shopConsoleController.shopInteractor.updateInventory();

        SellItemRequest sellItemRequest = new SellItemRequest("Generic", 7, 10);
        shopConsoleController.shopInteractor.sellItem(sellItemRequest);
        shopConsoleController.shopInteractor.sellItem(sellItemRequest);
//
//        AuctionHouseOutputBoundary auctionHouseOutputBoundary = new AuctionHouseConsoleView();
//        AuctionHouseInteractor auctionHouseInteractor = new AuctionHouseInteractor(new AuctionHouseConsoleController(), auctionHouseOutputBoundary, inMemoryItemsRepository , inMemoryBalanceRepository);
//
//        auctionHouseInteractor.startAuction(inMemoryItemsRepository.getInventory().get(0));

    }
}
