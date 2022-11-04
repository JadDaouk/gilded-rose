package gildedrose.Items;

public class GenericItem extends Item {


    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
