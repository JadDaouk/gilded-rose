package gildedrose.shop;

import gildedrose.BalanceGateway;
import gildedrose.item.Item;
import gildedrose.ItemGateway;
import gildedrose.shop.output.ShopConsoleView;
import gildedrose.shop.output.ShopItemResponse;
import gildedrose.shop.input.SellItemRequest;
import gildedrose.shop.input.ShopInputBoundary;
import gildedrose.shop.output.ShopOutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ShopInteractor implements ShopInputBoundary {

    private ItemGateway itemGateway;
    private BalanceGateway balanceGateway;
    public ShopOutputBoundary shopOutputBoundary = new ShopConsoleView();

    public ShopInteractor(ItemGateway itemGateway, BalanceGateway balanceGateway) {
        this.itemGateway = itemGateway;
        this.balanceGateway = balanceGateway;
    }


    public void updateInventory() {
        ArrayList<Item> items = itemGateway.getInventory();
        for (Item item : items) {
            item.update();
        }
        itemGateway.saveInventory(items);


    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item != null) {
            System.out.println("Item found");
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            this.balanceGateway.incrementBalance(item.getValue());
            itemGateway.saveInventory(items);
        }
    }

    public void displayInventory(){
        List<ShopItemResponse> itemsResponses = new ArrayList<>();
        for (Item i : itemGateway.getInventory()) {
            ShopItemResponse shopItemResponse = new ShopItemResponse(i.getName(), i.getSellIn(), i.getQuality(), i.getValue());
            itemsResponses.add(shopItemResponse);
        }
        shopOutputBoundary.displayInventory(itemsResponses);
    }

    public void displayBalance(){
        shopOutputBoundary.displayBalance(balanceGateway.getBalance());
    }


}
