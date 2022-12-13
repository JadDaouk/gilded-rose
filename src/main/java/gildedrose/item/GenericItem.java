package gildedrose.item;

public class GenericItem extends PerishableImprovableItem {

    public GenericItem(String name, int sellIn, int quality, int basePrice, int attack, int defense) {
        super(name, sellIn, quality, basePrice, attack, defense);
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
