package vendingmachine;

public enum Note {
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500);
    
    private int value;

    Note(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
