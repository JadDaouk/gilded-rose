package gildedrose.item;

public abstract class SalableItem extends Item{


    protected int basePrice;


    protected SalableItem(String name, int quality, int basePrice) {
        super(name, quality);
        this.basePrice = basePrice;
    }


    public int getValue() {
        return this.basePrice;
    }


}
