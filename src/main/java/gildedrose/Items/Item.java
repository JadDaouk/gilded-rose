package gildedrose.Items;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;
    public int basePrice;


    protected Item(String name, int sellIn, int quality, int basePrice) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.basePrice = basePrice;
    }


    public abstract void update();

    protected void cielQuality(int quality) {
        if (this.quality > quality)
            this.quality = quality;
    }

    protected void floorQuality(int quality) {
        if (this.quality < quality) {
            this.quality = 0;
        }
    }

    protected void floorSellIn(int sellIn) {
        if (this.sellIn < sellIn) {
            this.sellIn = 0;
        }
    }

    protected int getValue(){
        return this.basePrice;
    }
}
