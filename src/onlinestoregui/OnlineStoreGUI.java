/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinestoregui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author petersun
 */

// This class represents the GUI for the online store
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
        cartArea.setEditable(false); // Make the cart area non-editable

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

        // Action listeners for the buttons
        addToCartButton.addActionListener(this::addToCart);
        clearCartButton.addActionListener(this::clearCart);
        checkoutButton.addActionListener(this::checkout);

        // When gui is closed down commit changes to db and disconnect db
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    store.dbCommit();
                    store.dbShutdown();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Self-explanatory, it displays the products
        displayProducts();
    }

    // Adds the selected product to the cart
    private void addToCart(ActionEvent e) {
        int selectedIndex = productList.getSelectedIndex();
        if (store.isValidProduct(selectedIndex)) {
            Product selectedProduct = productList.getModel().getElementAt(selectedIndex);
            int quantity;
            try {
                quantity = Integer.parseInt(quantityField.getText());
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid quantity.");
                    return;
                }
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

    // Clears the cart
    private void clearCart(ActionEvent e) {
        store.getCart().clearItems();
        updateCartDisplay();
        JOptionPane.showMessageDialog(frame, "Cart cleared.");
    }

    // Handles the checkout process
    private void checkout(ActionEvent e) {
        if (store.getCart().getItems().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty. Please add items to the cart before checking out.");
            return;
        }

        customerName = JOptionPane.showInputDialog(frame, "Enter customer name:", "Customer Name", JOptionPane.PLAIN_MESSAGE);
        if (customerName != null && !customerName.trim().isEmpty()) {
            StringBuilder receipt = new StringBuilder("Receipt:\n");
            double totalAmount = 0;
            for (CartItem item : store.getCart().getItems()) {
                receipt.append(item.toString()).append("\n");
                totalAmount += item.getQuantity() * item.getProduct().getPrice();
            }
            receipt.append("Total: $").append(totalAmount).append("\n");

            JOptionPane.showMessageDialog(frame, "Total: $" + totalAmount, "Checkout", JOptionPane.INFORMATION_MESSAGE);

            saveRecords(receipt.toString());
            store.saveRecords(customerName);

            store.clearCart();
            updateCartDisplay();
        } else {
            JOptionPane.showMessageDialog(frame, "Customer name cannot be empty.");
        }
    }

    // Displays the products in the product list
    private void displayProducts() {
        DefaultListModel<Product> model = (DefaultListModel<Product>) productList.getModel();
        model.clear();
        for (Product product : store.getProducts()) {
            model.addElement(product);
        }
    }

    // Updates the cart display area
    private void updateCartDisplay() {
        StringBuilder cartContent = new StringBuilder();
        for (CartItem item : store.getCart().getItems()) {
            cartContent.append(item.toString()).append("\n");
        }
        cartArea.setText(cartContent.toString());
    }

    // Saves the receipt to a file
    private void saveRecords(String receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt", false))) {
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
        try {
            System.out.println("Starting Online Store GUI...");
            OnlineStore store = new OnlineStore();
            new OnlineStoreGUI(store);
            System.out.println("GUI initialized successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
