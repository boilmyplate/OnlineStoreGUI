/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

import java.sql.*;

/**
 *
 * @author emm
 */
public class DatabaseManager {

    private static final String URL = "jdbc:derby:OnlineStoreDB;create=true";
    private static final String USER = "pdc";
    private static final String PASSWORD = "pdc";

    private Connection connection;

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.AutoloadedDriver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to the database");
    }

    public void createTables() throws SQLException {
        String createProductTableSQL = "CREATE TABLE Products ("
                + "ID INT PRIMARY KEY, "
                + "NAME VARCHAR(255), "
                + "PRICE DOUBLE, "
                + "SIZE INT, "
                + ")";

        String createSalesTableSQL = "CREATE TABLE Sales ("
                + "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "CUSTOMER_NAME VARCHAR(255), "
                + "PRODUCT_ID INT, "
                + "QUANTITY INT, "
                + "TOTAL DOUBLE, "
                + "SALE_DATE TIMESTAMP)";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createProductTableSQL);
        statement.executeUpdate(createSalesTableSQL);
    }

    public void addColumn() throws SQLException {
        Statement statement = connection.createStatement();
        String addColumn = "ALTER TABLE Products ADD COLUMN SIZE INT";
        statement.executeUpdate(addColumn);
        System.out.println("Added column \"SIZE\"");
    }

    public void dropColumn() throws SQLException {
        Statement statement = connection.createStatement();
        String dropColumn = "ALTER TABLE Products DROP COLUMN IMAGE_PATH";
        statement.executeUpdate(dropColumn);
        System.out.println("Dropped column \"IMAGE_PATH\"");
    }

    // run if you want to reset a table and reinsert all data
    // replace table name in deleteData
    public void deleteData() throws SQLException {
        Statement statement = connection.createStatement();
        String deleteData = "DELETE FROM Products";
        statement.executeUpdate(deleteData);
        System.out.println("Deleted all data in table \"Products\"");
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Disconnected from the database");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseManager db = new DatabaseManager();
        db.connect();

        OnlineStore store = new OnlineStore();

        // Used to add products to database. Only need to run once.
        /*
        store.addShoes(new Shoes(1, "Air Jordan 1", 150, 10));
        store.addShoes(new Shoes(2, "Panda Dunk Low", 120, 9));
        store.addShoes(new Shoes(3, "New Balance 530", 100, 11));
        store.addShoes(new Shoes(4, "Astro Boots", 3000, 8));
        store.addShoes(new Shoes(5, "Gala Gaiters", 1700, 10));
        store.addShoes(new Shoes(6, "Lunar Glieds", 170, 7));
        store.addShoes(new Shoes(7, "EcoTreads", 90, 19));
         */
//                db.createTables();
//                db.addColumn();
//                db.dropColumn();
//        db.deleteData();
        db.disconnect();
    }
}
