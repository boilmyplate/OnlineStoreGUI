/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author petersun
 */
public class OnlineStore {

    private final List<Product> products;
    private final Cart cart;
    private final DatabaseManager dbManager;

    public OnlineStore() throws SQLException, ClassNotFoundException {
        products = new ArrayList<>();
        cart = new Cart();
        dbManager = new DatabaseManager();
        dbManager.connect(); // connect to database
        loadProducts();
    }

    private void loadProducts() throws SQLException {
        String query = "SELECT * FROM Products";
        Connection connection = dbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            double price = resultSet.getDouble("PRICE");
            int shoeSize = resultSet.getInt("IMAGE_PATH");
            products.add(new Product(id, name, price, shoeSize));
        }
        System.out.println("Products loaded from database");
    }

    public void addProduct(Product product) throws SQLException {
        products.add(product);
        String insertSQL = "INSERT INTO Products (ID, NAME, PRICE, SIZE) VALUES (?, ?, ?, ?)";
        Connection connection = (Connection) dbManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setInt(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product.getShoeSize());
        statement.executeUpdate();
        System.out.println("Product added: " + product.getName());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(new CartItem(product, quantity));
        System.out.println("Added to cart: " + quantity + " x " + product.getName());
    }

    public Cart getCart() {
        return cart;
    }

    public void saveRecords(String customerName) {
        SaleRecord saleRecord = new SaleRecord(cart.getItems(), customerName);
        saleRecord.save();
        System.out.println("Records saved for customer: " + customerName);
    }

    public boolean isValidProduct(int index) {
        return index >= 0 && index < products.size();
    }

    public void clearCart() {
        cart.clearItems();
        System.out.println("Cart cleared.");
    }
}
