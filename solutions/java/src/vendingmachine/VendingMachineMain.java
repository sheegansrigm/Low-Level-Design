package vendingmachine;

public class VendingMachineMain {
    public static void main(String[] args){
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 10);
        Product pepsi = new Product("Pepsi", 15);
        Product water = new Product("Water", 10);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);

        // Insert a note
        // vendingMachine.insertNote(Note.FIVE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.TEN);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.FIVE);
        // vendingMachine.insertCoin(Coin.QUARTER);
        // vendingMachine.insertCoin(Coin.QUARTER);
        // vendingMachine.insertCoin(Coin.QUARTER);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }    
}
