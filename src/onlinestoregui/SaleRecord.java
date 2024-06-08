/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;
import java.util.Date;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class SaleRecord {
    private List<CartItem> items;
    private String customerName;

    public SaleRecord(List<CartItem> items, String customerName) {
        this.items = items;
        this.customerName = customerName;
        System.out.println("SaleRecord initialized for customer: " + customerName);
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SalesRecord.txt", true))) {
            String timestamp = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date());
            writer.write(timestamp);
            writer.newLine();
            writer.write("Customer: " + customerName);
            writer.newLine();
            double total = 0;
            for (CartItem item : items) {
                writer.write("Item: " + item.getProduct().getName());
                writer.newLine();
                writer.write("Quantity: " + item.getQuantity());
                writer.newLine();
                double itemTotal = item.getQuantity() * item.getProduct().getPrice();
                writer.write("Total: $" + itemTotal);
                writer.newLine();
                total += itemTotal;
            }
            writer.write("Grand Total: $" + total);
            writer.newLine();
            writer.write("----");
            writer.newLine();
            System.out.println("Record saved for customer: " + customerName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the record: " + e.getMessage());
        }
    }
}