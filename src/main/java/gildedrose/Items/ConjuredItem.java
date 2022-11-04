package gildedrose.Items;

public class ConjuredItem extends Item {


    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
