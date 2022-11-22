package gildedrose;

public class Main {

    public static void main(String[] args) {

        ShopOutputBoundary shopOutputBoundary = new ShopOutputBoundary();

        //shopOutputBoundary.displayInventory();
        shopOutputBoundary.updateInventory();
       // shopOutputBoundary.displayInventory();

        //shopOutputBoundary.displayBalance();
        shopOutputBoundary.sellItem("Generic", 1);
        //shopOutputBoundary.displayBalance();
    }
}
