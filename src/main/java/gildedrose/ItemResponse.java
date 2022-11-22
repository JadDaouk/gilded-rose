package gildedrose;

public class ItemResponse {
    public String name;
    public int sellIn;
    public int quality;
    public int value;

    protected ItemResponse(String name, int sellIn, int quality, int value) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.value = value;
    }
}
