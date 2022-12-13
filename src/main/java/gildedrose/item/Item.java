package gildedrose.item;

public abstract class Item {


    protected String name;
    protected int quality;


    protected int basePrice;


    protected Item(String name, int quality, int basePrice) {
        this.name = name;
        this.quality = quality;
        this.basePrice = basePrice;
    }


    protected void cielQuality(int quality) {
        if (this.quality > quality)
            this.quality = quality;
    }

    protected void floorQuality(int quality) {
        if (this.quality < quality) {
            this.quality = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
