package gildedrose.shop.output.response;

public class ShopItemResponse {
    public String name;
    public int quality;
    public int value;

    public ShopItemResponse(String name, int quality, int value) {
        this.name = name;
        this.quality = quality;
        this.value = value;
    }


}
