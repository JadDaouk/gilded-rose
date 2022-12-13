package gildedrose.auctionHouse.input;

import gildedrose.auctionHouse.AuctionHouseInteractor;
import gildedrose.balance.repositories.InMemoryBalanceRepository;
import gildedrose.item.repositories.InMemoryItemsRepository;

import java.util.Scanner;

public class AuctionHouseConsoleController {
    public InMemoryBalanceRepository inMemoryBalanceRepository = new InMemoryBalanceRepository();
    public InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();

    public AuctionHouseInteractor auctionHouseInteractor = new AuctionHouseInteractor(inMemoryItemsRepository,inMemoryBalanceRepository);

    public Scanner sc = new Scanner(System.in);


    public void console(){

        //TODO: implement console
        auctionHouseInteractor.controller = this;
        // ici ou main / test ?
        auctionHouseInteractor.startAuction(inMemoryItemsRepository.getInventory().get(1));

    }

    public int getBidAmount()
    {
        return sc.nextInt();
    }
}
