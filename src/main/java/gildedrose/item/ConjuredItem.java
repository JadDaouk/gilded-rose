package gildedrose.item;

public class ConjuredItem extends PerishableImprovableItem {


    public ConjuredItem(String name, int sellIn, int quality, int basePrice, int attack, int defense) {
        super(name, sellIn, quality, basePrice, attack, defense);
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
