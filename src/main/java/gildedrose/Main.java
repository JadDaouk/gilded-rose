package gildedrose;

public class Main {

    public static void main(String[] args) {

        ConsoleUI consoleUi = new ConsoleUI();

        consoleUi.displayInventory();
        consoleUi.updateInventory();
        consoleUi.displayInventory();

        consoleUi.displayBalance();
        consoleUi.sellItem("Generic", 1);
        consoleUi.displayBalance();
    }
}
