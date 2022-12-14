package gildedrose.item;

public class AggingItem extends PerishableItem {

    public AggingItem(String name, int sellIn, int quality, int basePrice) {
        super(name, sellIn, quality, basePrice);
    }

    public void update() {
        this.sellIn--;
        this.quality++;

        floorQuality(0);
        cielQuality(50);
        floorSellIn(0);
    }
}
