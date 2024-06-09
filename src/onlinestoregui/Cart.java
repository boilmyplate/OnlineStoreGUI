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
public class Cart {
    private final List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
        System.out.println("Cart initialized.");
    }

    public void addItem(CartItem item) {
        items.add(item);
        System.out.println("Item added to cart: " + item.getProduct().getName() + " - Quantity: " + item.getQuantity());
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clearItems() {
        items.clear();
        System.out.println("All items removed from cart.");
    }
}