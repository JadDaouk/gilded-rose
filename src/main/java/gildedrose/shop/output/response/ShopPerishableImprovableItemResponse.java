package gildedrose.shop.output.response;

public class ShopPerishableImprovableItemResponse {
    public String name;
    public int sellIn;
    public int quality;
    public int value;
    public int attack;
    public int defense;

    public ShopPerishableImprovableItemResponse(String name, int sellIn, int quality, int value, int attack, int defense) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.value = value;
        this.attack = attack;
        this.defense = defense;
    }


}
