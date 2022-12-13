package gildedrose.shop.output.response;

public class ShopImprovableItemResponse {
    public String name;
    public int quality;
    public int value;
    public int attack;
    public int defense;

    public ShopImprovableItemResponse(String name, int quality, int value, int attack, int defense) {
        this.name = name;
        this.quality = quality;
        this.value = value;
        this.attack = attack;
        this.defense = defense;
    }


}
