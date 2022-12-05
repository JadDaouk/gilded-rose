package gildedrose.shop.input;

public class SellItemRequest {

    private String type;
    private int quality;
    private double price;

    public SellItemRequest(String type, int quality, double price) {
        this.type = type;
        this.quality = quality;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getQuality() {
        return quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
