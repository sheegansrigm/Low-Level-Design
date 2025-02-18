package vendingmachine;

public class VendingMachine {

    private static VendingMachine vendingMachine;
    private VendingMachineState currenState;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private Product selectedProduct;
    private double totalAmount;
    Inventory inventory;

    private VendingMachine(){
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currenState = idleState;
        selectedProduct = null;
        totalAmount = 0;
        inventory = new Inventory();
    }

    public static synchronized VendingMachine getInstance(){
        if(vendingMachine == null){
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void setState(VendingMachineState state){
        this.currenState = state;
    }

    public void selectProduct(Product product){
        currenState.selectProduct(product);
    }

    public void insertCoin(Coin coin){
        currenState.insertCoin(coin);
    }

    public void insertNote(Note note){
        currenState.insertNote(note);
    }

    public void returnChange(){
        currenState.returnChange();
    }

    public void dispenseProduct(){
        currenState.dispenseProduct();
    }

    public VendingMachineState getIdleState(){
        return idleState;
    }

    public VendingMachineState getReadyState(){
        return readyState;
    }

    public VendingMachineState getDispenseState(){
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState(){
        return returnChangeState;
    }

    public void addCoin(Coin coin){
        totalAmount += coin.getValue();
    }

    public void addNote(Note note){
        totalAmount += note.getValue();
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public void setSelectedProduct(Product selectedProduct){
        this.selectedProduct = selectedProduct;
    }

    public Product getSelectedProduct(){
        return selectedProduct;
    }
}
