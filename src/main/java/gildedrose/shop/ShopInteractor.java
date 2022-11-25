package gildedrose.shop;

import gildedrose.balance.repositories.Balance;
import gildedrose.item.Item;
import gildedrose.ItemGateway;
import gildedrose.shop.output.ShopItemResponse;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.shop.input.ShopInputBoundary;
import gildedrose.shop.output.ShopOutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ShopInteractor implements ShopInputBoundary {

    private ItemGateway itemGateway;
    private ShopOutputBoundary shopOutputBoundary;

    private Balance balance;

    public ShopInteractor(ItemGateway itemGateway, ShopOutputBoundary shopOutputBoundary, Balance balance) {
        this.itemGateway = itemGateway;
        this.shopOutputBoundary = shopOutputBoundary;
        this.balance = balance;
    }


    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            item.update();
        }
        itemGateway.saveInventory(items);

        convertItemAndDisplay(items);
    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item != null) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            Balance.getbalance() += item.getValue();
            itemGateway.saveInventory(items);
        }

        shopOutputBoundary.displayBalance(balance);
    }

    private void convertItemAndDisplay(List<Item> items)
    {
        List<ShopItemResponse> itemsResponses = new ArrayList<>();

        for (Item i : items) {
            ShopItemResponse itemresponse = new ShopItemResponse(i.getName(), i.getSellIn(), i.getQuality(), i.getValue());
            itemsResponses.add(itemresponse);
        }
        shopOutputBoundary.displayInventory(itemsResponses);
    }

    public int getBalance()
    {
        return balance;
    }

}
