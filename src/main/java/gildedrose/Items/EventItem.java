package gildedrose.Items;

public class EventItem extends Item {

    public EventItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
