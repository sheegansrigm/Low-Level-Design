package vendingmachine;

import java.util.Map;
import java.util.HashMap;

public class Inventory {
    Map<Product, Integer> products;

    public Inventory(){
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        products.put(product,quantity);
    }

    public void updateQuantity(Product product,int quantity){
        products.put(product,quantity);
    }

    public int getQuantity(Product product){
        return products.getOrDefault(product, 0);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public boolean isAvailable(Product product){
        return products.containsKey(product) && products.get(product) > 0;
    }
}
