package by.derzhanovich.cShop.model;

import java.util.*;

public class Basket {
    private Map<Integer, Product> products;
    private int totalPrice = 0;

    public Basket() {
     products = new HashMap<>();
    }
    public void addProduct(Product product) {
        products.put(product.getId(), product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(int productId) {
        Product product = products.get(productId);
        products.remove(productId);
        totalPrice -= product.getPrice();
    }
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }


    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void clear() {
        products.clear();
    }
}
