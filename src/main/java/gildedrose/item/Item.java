package gildedrose.item;

public abstract class Item {


    protected String name;
    protected int sellIn;
    protected int quality;
    protected int basePrice;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getValue() {
        return this.basePrice;
    }

}
