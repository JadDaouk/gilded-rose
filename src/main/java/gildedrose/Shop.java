package gildedrose;

import gildedrose.Items.Item;

import java.util.List;

public class Shop
{
    public List<Item> inventory;

    public Shop(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void updateQuality() {
        for (Item item : inventory) {
            item.update();
        }
    }



//	private List<Item> stock = new ArrayList<Item>();
//
//	public void endDay()
//	{
//		stock.stream().forEach(e -> e.updateQuality());
//	}
//
//	public void addProduct(Item item)
//	{
//		stock.add(item);
//	}
//
//	public void sellProduct(Item item)
//	{
//		stock.remove(stock.indexOf(item));
//	}
}
