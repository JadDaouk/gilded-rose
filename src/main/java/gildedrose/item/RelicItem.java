package gildedrose.item;

public class RelicItem extends Item  {

    private double value = 100;

    public RelicItem(String name, int quality) {
        super(name, quality);
    }

    public double getValue() {
        return value;
    }
}
