package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Shop
{
	private List<Item> stock = new ArrayList<Item>();

	public void endDay()
	{
		stock.stream().forEach(e -> e.updateQuality());
	}

	public void addProduct(Item item)
	{
		stock.add(item);
	}

	public void sellProduct(Item item)
	{
		stock.remove(stock.indexOf(item));
	}
}
