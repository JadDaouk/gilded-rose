package gildedrose;

public class SellItemRequest {

    private String type;
    private int quality;

    public SellItemRequest(String type, int quality)
    {
        this.type = type;
        this.quality = quality;
    }

    public String getType()
    {
        return type;
    }

    public int getQuality()
    {
        return quality;
    }




}
