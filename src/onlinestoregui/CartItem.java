/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

/**
 *
 * @author petersun
 */

//This class represents an item in the shopping cart
public class CartItem {
    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Returns the product
    public Product getProduct() {
        return product;
    }

    // Returns the quantity of the product
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + product.toString();
    }
}
