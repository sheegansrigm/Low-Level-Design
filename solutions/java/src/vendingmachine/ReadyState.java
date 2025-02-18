package vendingmachine;

public class ReadyState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("Product is already been selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin){
        vendingMachine.addCoin(coin);
        System.out.println("Coin added "+coin);
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note){
        vendingMachine.addCoin(note);
        System.out.println("Note added "+note);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Make payment first.");
    }

    @Override
    public void returnChange(){
        System.out.println("No change to return.");
    }

    public void checkPaymentStatus(){
        if(vendingMachine.getTotalAmount() >= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
