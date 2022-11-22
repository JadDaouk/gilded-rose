package gildedrose.Items;

public class AggingItem extends Item {


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

    public int getValue(){
        return this.basePrice;
    }
}
