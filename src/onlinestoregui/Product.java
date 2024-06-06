/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

/**
 *
 * @author petersun
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private String imagePath; // Add this field

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // New constructor to include image path
    public Product(int id, String name, double price, String imagePath) {
        this(id, name, price);
        this.imagePath = imagePath;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }
}