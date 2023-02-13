package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final int maxCount;
    private List<Product> products = new ArrayList<>();

    public VendingMachine(int maxCount) {
        this.maxCount = maxCount;
    }
    public VendingMachine(int maxCount, List<Product> products) {
        this(maxCount);
        this.products = products;
    }

    public VendingMachine add(Product product) throws Exception {
        if (products.size() < maxCount) products.add(product);
        else throw new Exception("Vending machine overload");
        return this;
    }
    public VendingMachine add(String name, int price) throws Exception {
        this.add(new Product(name, price));
        return this;
    }

    public VendingMachine add(String name, int price, int count) throws Exception {
        for (int i = 0; i < count; i++)
            this.add(name, price);
        return this;
    }

    public Product getProductByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.remove(i);
            }
        }
        return null;
    }

    public int getProductByName(String name, int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            Product temp = getProductByName(name);
            if (temp == null) break;
            else result++;
        }
        return result;
    }

    public Product getProductByCost (double price) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() == price) {
                return products.remove(i);
            }
        }
        return null;
    }

    public List<Product> contains() {
        return products;
    }
}
