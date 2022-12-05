package gildedrose.balance.repositories;

import gildedrose.BalanceGateway;

public class FileBalanceRepository implements BalanceGateway {
    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void incrementBalance(double balance) {
    }
}

