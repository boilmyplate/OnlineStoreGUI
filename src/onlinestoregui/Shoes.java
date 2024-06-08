/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

/**
 *
 * @author petersun
 */
public class Shoes extends Product {
    private final int size;

    public Shoes(int id, String name, double price, int size) {
        super(id, name, price);
        this.size = size;
    }

    public int getShoeSize() {
        return size;
    }

    @Override
    public String toString() {
        return getName() + " (Size: " + size + ")";
    }
}