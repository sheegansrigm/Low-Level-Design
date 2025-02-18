package vendingmachine;
public class ReturnChangeState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(int productId) {
        System.out.println("Please take your change first");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please take your change first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please take your change first");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalAmount()-vendingMachine.getSelectedProduct().getPrice();
        System.out.println("Change returned: "+change);
        vendingMachine.setTotalAmount(0);
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please take your change first");
    }
}
