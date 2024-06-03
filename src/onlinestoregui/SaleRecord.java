/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;
import java.util.Date;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SaleRecord {
    private Date date;
    private String customerName;
    private Product product;
    private int quantity;
    private double totalPrice;

    public SaleRecord(String customerName, Product product, int quantity, double totalPrice) {
        this.date = new Date(); // Assign the current date when the SaleRecord object is created
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    @Override
    public String toString() {
        return String.format("%s \nCustomer: %s \nItem: %s \nQuantity: %d \nTotal: $%.2f\n", 
                date.toString(), customerName, product.toString(), quantity, totalPrice);
    }
}