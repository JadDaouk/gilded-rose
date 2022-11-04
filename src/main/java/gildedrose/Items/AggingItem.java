package gildedrose.Items;

public class AggingItem extends Item {


    public AggingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        this.sellIn--;
        this.quality++;

        floorQuality(0);
        cielQuality(50);
        floorSellIn(0);
    }
}
