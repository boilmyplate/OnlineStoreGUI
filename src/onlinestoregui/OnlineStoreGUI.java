/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinestoregui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author petersun
 */
public class OnlineStoreGUI {

    private OnlineStore store;
    private JFrame frame;
    private JList<Product> productList;
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton clearCartButton;
    private JTextField quantityField;
    private JTextArea cartArea;
    private String customerName;
    private double totalAmount;

    public OnlineStoreGUI(OnlineStore store) {
        this.store = store;
        frame = new JFrame("PJ Sneaker Store");

        productList = new JList<>(new DefaultListModel<>());

        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        clearCartButton = new JButton("Clear Cart");
        quantityField = new JTextField(5);
        cartArea = new JTextArea(10, 30);

        // Display welcome message
        JOptionPane.showMessageDialog(frame, "Hello, welcome to PJ Sneaker Store", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBorder(BorderFactory.createTitledBorder("Products"));
        northPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Cart"));
        centerPanel.add(new JScrollPane(cartArea), BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        southPanel.add(new JLabel("Quantity:"));
        southPanel.add(quantityField);
        southPanel.add(addToCartButton);
        southPanel.add(checkoutButton);
        southPanel.add(clearCartButton);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (store.isValidProduct(selectedIndex)) {
                    Product selectedProduct = productList.getModel().getElementAt(selectedIndex);
                    int quantity;
                    try {
                        quantity = Integer.parseInt(quantityField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid quantity.");
                        return;
                    }
                    store.addToCart(selectedProduct, quantity);
                    updateCartDisplay();
                    JOptionPane.showMessageDialog(frame, selectedProduct.getName() + " added to cart.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a product to add to the cart.");
                }
            }
        });

        clearCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store.getCart().clearItems();
                updateCartDisplay();
                JOptionPane.showMessageDialog(frame, "Cart cleared.");
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerName = JOptionPane.showInputDialog(frame, "Enter customer name:", "Customer Name", JOptionPane.PLAIN_MESSAGE);
                if (customerName != null && !customerName.trim().isEmpty()) {
                    StringBuilder receipt = new StringBuilder("Receipt:\n");
                    totalAmount = 0;
                    for (CartItem item : store.getCart().getItems()) {
                        receipt.append(item.getQuantity()).append(" x ").append(item.getProduct().getName()).append(" - $").append(item.getProduct().getPrice()).append("\n");
                        totalAmount += item.getQuantity() * item.getProduct().getPrice();
                    }
                    receipt.append("Total: $").append(totalAmount).append("\n");

                    JOptionPane.showMessageDialog(frame, "Total: $" + totalAmount, "Checkout", JOptionPane.INFORMATION_MESSAGE);

                    // Save the receipt to a file
                    saveRecords(receipt.toString());

                    store.clearCart();
                    updateCartDisplay();
                } else {
                    JOptionPane.showMessageDialog(frame, "Customer name cannot be empty.");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        displayProducts(); // Populate the product list
    }

    public void displayProducts() {
        DefaultListModel<Product> model = (DefaultListModel<Product>) productList.getModel();
        model.clear();
        for (Product product : store.getProducts()) {
            model.addElement(product);
        }
    }

    private void updateCartDisplay() {
        StringBuilder cartContent = new StringBuilder();
        for (CartItem item : store.getCart().getItems()) {
            cartContent.append(item.getQuantity()).append(" x ").append(item.getProduct().getName()).append(" - $").append(item.getProduct().getPrice()).append("\n");
        }
        cartArea.setText(cartContent.toString());
    }

    private void saveRecords(String receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt", true))) {
            writer.write(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date()));
            writer.newLine();
            writer.write("Customer: " + customerName);
            writer.newLine();
            writer.write(receipt);
            writer.write("----\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving receipt: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Online Store GUI...");
        try {
            OnlineStore store = new OnlineStore();
            store.addProduct(new Shoes(1, "Air Jordan 1", 150, 10));
            store.addProduct(new Shoes(2, "Panda Dunk Low", 120, 9));
            store.addProduct(new Shoes(3, "New Balance 530", 100, 11));

            System.out.println("GUI initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
