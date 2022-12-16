package gildedrose.shop;

import gildedrose.BalanceGateway;
import gildedrose.item.*;
import gildedrose.ItemGateway;
import gildedrose.shop.output.ShopConsoleView;
import gildedrose.shop.output.response.*;
import gildedrose.shop.input.request.SellItemRequest;
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
            if (item instanceof PerishableItem perishableItem) {
                perishableItem.update();
            }
            else if (item instanceof RelicItem relicItem) {
                balanceGateway.incrementBalance(relicItem.getValue());
            }
        }
        itemGateway.saveInventory(items);


    }

    public void sellItem(SellItemRequest sellItemRequest) {
        Item item = itemGateway.findItem(sellItemRequest);
        if (item instanceof SalableItem salableItem) {
            ArrayList<Item> items = itemGateway.getInventory();
            items.remove(item);
            this.balanceGateway.incrementBalance(salableItem.getValue());
            itemGateway.saveInventory(items);
        }
    }

    public void displayInventory() {
        List<ShopPerishableItemResponse> shopPerishableItemResponses = new ArrayList<>();
        List<ShopItemResponse> shopItemResponses = new ArrayList<>();
        List<ShopSalableItemResponse> shopSalableItemResponses = new ArrayList<>();
        List<ShopPerishableImprovableItemResponse> shopPerishableImprovableItemResponses = new ArrayList<>();
        List<ShopImprovableItemResponse> shopImprovableItemResponses = new ArrayList<>();
        for (Item item : itemGateway.getInventory()) {
            if (item instanceof PerishableItem perishableItem) {
                if (perishableItem instanceof PerishableImprovableItem perishableImprovableItem) {
                    ShopPerishableImprovableItemResponse shopPerishableImprovableItem = new ShopPerishableImprovableItemResponse(perishableImprovableItem.getName(), perishableImprovableItem.getSellIn(), perishableImprovableItem.getQuality(), perishableImprovableItem.getValue(), perishableImprovableItem.getAttack(), perishableImprovableItem.getDefense());
                    shopPerishableImprovableItemResponses.add(shopPerishableImprovableItem);
                } else {
                    ShopPerishableItemResponse shopPerishableItemResponse = new ShopPerishableItemResponse(perishableItem.getName(), perishableItem.getSellIn(), perishableItem.getQuality(), perishableItem.getValue());
                    shopPerishableItemResponses.add(shopPerishableItemResponse);
                }
            }
            else if (item instanceof ImprovableItem improvableItem) {
                ShopImprovableItemResponse shopImprovableItem = new ShopImprovableItemResponse(improvableItem.getName(), improvableItem.getQuality(), improvableItem.getValue(), improvableItem.getAttack(), improvableItem.getDefense());
                shopImprovableItemResponses.add(shopImprovableItem);
            }
            else if (item instanceof SalableItem salableItem) {
                ShopSalableItemResponse shopSalableItemResponse = new ShopSalableItemResponse(salableItem.getName(), salableItem.getQuality(), salableItem.getValue());
                shopSalableItemResponses.add(shopSalableItemResponse);
            }else {
                ShopItemResponse shopItemResponse = new ShopItemResponse(item.getName(), item.getQuality());
                shopItemResponses.add(shopItemResponse);
            }

        }
        shopOutputBoundary.displayInventory(shopPerishableItemResponses, shopItemResponses, shopPerishableImprovableItemResponses, shopImprovableItemResponses, shopSalableItemResponses);
    }

    public void displayBalance() {
        shopOutputBoundary.displayBalance(balanceGateway.getBalance());
    }


}
