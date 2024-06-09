/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

/**
 *
 * @author petersun
 */

// This class represents a shoe product in the online store
public class Shoes extends Product {
    private final int size;

    public Shoes(int id, String name, double price, int size) {
        super(id, name, price);
        this.size = size;
    }

    // Returns the shoe size
    public int getShoeSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + " (Size: " + size + ")";
    }
}