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

// This class represents a shopping cart that contains items
public class Cart {
    private final List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
        System.out.println("Cart initialized.");
    }

    // Adds an item to the cart
    public void addItem(CartItem item) {
        items.add(item);
        System.out.println("Item added to cart: " + item.getProduct().getName() + " - Quantity: " + item.getQuantity());
    }

    // Returns the list of items in the cart
    public List<CartItem> getItems() {
        return items;
    }

    // Clears all items from the cart
    public void clearItems() {
        items.clear();
        System.out.println("All items removed from cart.");
    }
}