package gildedrose.balance.repositories;

import gildedrose.BalanceGateway;
import gildedrose.item.repositories.InMemoryItemsRepository;

public class InMemoryBalanceRepository implements BalanceGateway {

    private InMemoryItemsRepository inMemoryItemsRepository = new InMemoryItemsRepository();

    //TODO
}

