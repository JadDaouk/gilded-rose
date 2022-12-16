package gildedrose.shop.output.response;

public class ShopSalableItemResponse {
    public String name;
    public int quality;
    public int value;

    public ShopSalableItemResponse(String name, int quality, int value) {
        this.name = name;
        this.quality = quality;
        this.value = value;
    }


}
