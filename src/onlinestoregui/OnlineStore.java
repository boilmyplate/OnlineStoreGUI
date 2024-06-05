/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author petersun
 */
public class OnlineStore {
    private List<Product> products;
    private Cart cart;

    public OnlineStore() {
        products = new ArrayList<>();
        cart = new Cart();
        System.out.println("OnlineStore initialized.");
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(new CartItem(product, quantity));
        System.out.println("Added to cart: " + quantity + " x " + product.getName());
    }

    public Cart getCart() {
        return cart;
    }

    public void saveRecords(String customerName) {
        SaleRecord saleRecord = new SaleRecord(cart.getItems(), customerName);
        saleRecord.save();
        System.out.println("Records saved for customer: " + customerName);
    }

    public boolean isValidProduct(int index) {
        return index >= 0 && index < products.size();
    }

    public void clearCart() {
        cart.clearItems();
        System.out.println("Cart cleared.");
    }
}