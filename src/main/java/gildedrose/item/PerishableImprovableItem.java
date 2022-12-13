package gildedrose.item;

public abstract class PerishableImprovableItem extends PerishableItem {

    protected int attack;
    protected int defense;

    protected PerishableImprovableItem(String name, int quality, int sellIn, int basePrice, int attack, int defense) {
        super(name, quality, sellIn, basePrice);
        this.attack = attack;
        this.defense = defense;
    }

    public abstract void update();

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
