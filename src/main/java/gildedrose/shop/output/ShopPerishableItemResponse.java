package gildedrose.shop.output;

public class ShopPerishableItemResponse {
    public String name;
    public int sellIn;
    public int quality;
    public int value;

    public ShopPerishableItemResponse(String name, int sellIn, int quality, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.value = value;
    }


}
