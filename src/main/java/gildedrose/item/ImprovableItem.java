package gildedrose.item;

public abstract class ImprovableItem extends Item {

    protected int attack;
    protected int defense;

    protected ImprovableItem(String name, int quality, int basePrice, int attack, int defense) {
        super(name, quality, basePrice);
        this.attack = attack;
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
