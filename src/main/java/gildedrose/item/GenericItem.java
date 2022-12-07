package gildedrose.item;

public class GenericItem extends PerishableItem {

    public GenericItem(String name, int sellIn, int quality, int basePrice) {
        super(name, sellIn, quality, basePrice);
    }

    public void update() {
        this.sellIn--;
        this.quality--;

        if (this.sellIn <= 0) this.quality--;


        floorQuality(0);
        cielQuality(50);
        floorSellIn(0);

    }
}
