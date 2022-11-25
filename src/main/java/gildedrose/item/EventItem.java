package gildedrose.item;

public class EventItem extends Item {

    public EventItem(String name, int sellIn, int quality, int basePrice) {
        super(name, sellIn, quality, basePrice);
    }

    public void update() {
        this.sellIn--;
        this.quality++;

        if (this.sellIn <= 10) {
            this.quality++;
        }
        if (this.sellIn <= 5) {
            this.quality++;
        }
        if (this.sellIn <= 0) {
            this.quality = 0;
        }

        cielQuality(50);
        floorQuality(0);
        floorSellIn(0);
    }
}
