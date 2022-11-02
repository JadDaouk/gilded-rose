package gildedrose;

import java.util.Objects;

public class Item {
    private String name;
    private int sellIn;
    private int quality;
    private boolean conjured;

    public Item(String name, int sellIn, int quality, boolean conjured) {
        if (Objects.equals(name, "Sulfuras")) {
            new Item("Sulfuras", 80, false);
        } else {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
            this.conjured = conjured;
        }
    }

    public Item(String name, int quality, boolean conjured) {
        this.name = name;
        this.quality = quality;
        this.conjured = conjured;
    }

    public void updateQuality() {

        int quota = 1;

        if ("Aged Brie".equals(this.name) || "Backstage passes".equals(this.name)) {
            if (this.sellIn != 0 && this.sellIn <= 5) {
                quota = 3;
            } else if (this.sellIn != 0 && this.sellIn <= 10) {
                quota = 2;
            }
        } else if ("Sulfuras".equals(this.name)) {
            quota = 0;
        }
        if (this.conjured) {
            quota = quota * 2;
        }


        if (("Aged Brie".equals(this.name) || "Backstage passes".equals(this.name)) && this.quality < 50) {
            if (this.sellIn != 0 && this.sellIn <= 5 && this.quality <= 48) {
                this.quality = this.quality + 3;
            } else if (this.sellIn != 0 && this.sellIn <= 10 && this.quality <= 48) {
                this.quality = this.quality + 2;
            } else if (this.sellIn == 0) {
                this.quality = 0;
            } else {
                this.quality = this.quality + 1;
            }
            this.sellIn--;
        } else if (Objects.equals(this.name, "Sulfuras")) {
            //nothing
        } else if (this.sellIn == 0 && this.quality >= 2) {
            this.quality = this.quality - 2;
            this.sellIn--;
        } else if (this.quality >= 2 && this.sellIn >= 2 && this.conjured) {
            this.quality = this.quality - 2;
            this.sellIn = this.sellIn - 2;
        } else if (this.quality >= 1 && this.sellIn >= 1) {
            this.quality--;
            this.sellIn--;
        }
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
