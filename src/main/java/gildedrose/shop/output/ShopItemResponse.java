package gildedrose.shop.output;

public class ShopItemResponse {
    public String name;
    public int sellIn;
    public int quality;
    public int value;

    public ShopItemResponse(String name, int sellIn, int quality, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.value = value;
    }
}
