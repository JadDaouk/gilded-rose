package gildedrose.item;

public class ConjuredItem extends PerishableItem {


    public ConjuredItem(String name, int sellIn, int quality, int basePrice) {
        super(name, sellIn, quality, basePrice);
    }

    public void update(){
        this.sellIn --;
        this.quality -= 2;

        if(this.sellIn <= 0) this.quality -= 2;

        floorQuality(0);
        cielQuality(50);
        floorSellIn(0);
    }
}
