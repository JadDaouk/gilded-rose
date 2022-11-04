package gildedrose.Items;

public abstract class Item {
    public String name;
    public int sellIn;
    public int quality;


    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public abstract void update();

    protected void cielQuality(int quality) {
        if (this.quality > quality)
            this.quality = quality;
    }

    protected void floorQuality(int quality) {
        if (this.quality < quality) {
            this.quality = 0;
        }
    }

    protected void floorSellIn(int sellIn) {
        if (this.sellIn < sellIn) {
            this.sellIn = 0;
        }
    }
}

//    public void update() {
//
//        if (isSulfuras()) return;
//
//        this.sellIn -= 1;
//
//        if (isAgedBrie()) {
//            this.quality++;
//        } else if (isBackstagePasses()) {
//            this.quality++;
//
//            if (this.sellIn <= 10) {
//                this.quality++;
//            }
//            if (this.sellIn <= 5) {
//                this.quality++;
//            }
//            if (this.sellIn <= 0) {
//                this.quality = 0;
//            }
//        } else if(isConjured()) {
//            this.quality -= 2;
//        }
//        else {
//            this.quality -= 1;
//        }
//        if (this.sellIn <= 0 && isConjured()) {
//            this.quality -= 2;
//        }
//        else if (this.sellIn <= 0) {
//            this.quality -= 1;
//        }
//
//        cielQuality(50);
//        floorQuality(0);
//        floorSellIn(0);
//    }
//
//    private boolean isBackstagePasses() {
//        return "Backstage passes".equals(this.name);
//    }
//
//    private boolean isAgedBrie() {
//        return "Aged Brie".equals(this.name);
//    }
//
//    private boolean isSulfuras() {
//        return "Sulfuras".equals(this.name);
//    }
//    public boolean isConjured() {
//        return name.contains("Conjured");
//    }
//    private void cielQuality(int quality) {
//        if (this.quality > quality)
//            this.quality = quality;
//    }
//
//    private void floorQuality(int quality) {
//        if (this.quality < quality) {
//            this.quality = 0;
//        }
//    }
//
//    private void floorSellIn(int sellIn) {
//        if (this.sellIn < sellIn) {
//            this.sellIn = 0;
//        }
//    }//}


//    private String name;
//    private int sellIn;
//    private int quality;
//    private boolean conjured;
//    private boolean legendary = false;
//    private static final ArrayList<String> legendaryItems = new ArrayList<>();
//
//    private static void initLegendaryItems() {
//        legendaryItems.add("Sulfuras");
//    }
//
//    public Item(String name, int sellIn, int quality, boolean conjured) {
//        if (legendaryItems.stream().anyMatch(e -> Objects.equals(e, name))) {
//            new Item("name", 80, false, true);
//        } else {
//            this.name = name;
//            this.sellIn = sellIn;
//            this.quality = quality;
//            this.conjured = conjured;
//        }
//    }
//
//    public Item(String name, int quality, boolean conjured, boolean legendary) {
//        this.name = name;
//        this.quality = quality;
//        this.conjured = conjured;
//        this.legendary = legendary;
//    }
//
