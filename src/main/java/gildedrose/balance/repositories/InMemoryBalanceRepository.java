package gildedrose.balance.repositories;

import gildedrose.BalanceGateway;
import gildedrose.item.repositories.InMemoryItemsRepository;

public class InMemoryBalanceRepository implements BalanceGateway {

    private double balance = 0;
    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void incrementBalance(double balance) {
        this.balance += balance;
    }
}

