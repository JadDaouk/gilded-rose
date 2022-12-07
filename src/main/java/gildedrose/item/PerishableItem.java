package gildedrose.item;

public abstract class PerishableItem extends Item {

    protected int sellIn;

    protected PerishableItem(String name, int sellIn, int quality, int basePrice) {
        super(name, quality, basePrice);
        this.sellIn = sellIn;
    }

    protected void floorSellIn(int sellIn) {
        if (this.sellIn < sellIn) {
            this.sellIn = 0;
        }
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public abstract void update();
}
