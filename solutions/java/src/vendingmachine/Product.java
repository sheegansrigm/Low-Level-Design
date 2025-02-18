package vendingmachine;

public class Product {
    private String name;
    // private int id;
    private double price;

    public Product(String name,double price){
        this.name = name;
        // this.id = id;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }
}
