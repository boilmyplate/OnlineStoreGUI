/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to the database");
    }

    public void createTables() throws SQLException {
        String createProductTableSQL = "CREATE TABLE Products ("
                + "ID INT PRIMARY KEY, "
                + "NAME VARCHAR(255), "
                + "PRICE DOUBLE, "
                + "SIZE INT)";

        String createSalesTableSQL = "CREATE TABLE Sales ("
                + "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "CUSTOMER_NAME VARCHAR(255), "
                + "PRODUCT_ID INT, "
                + "QUANTITY INT, "
                + "TOTAL DOUBLE, "
                + "SALE_DATE TIMESTAMP)";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(createProductTableSQL);
            stmt.executeUpdate(createSalesTableSQL);
            System.out.println("Tables created");
        }
    }

    public void insertSaleRecord(String customerName, int productId, int quantity, double total) throws SQLException {
        String insertSQL = "INSERT INTO Sales (CUSTOMER_NAME, PRODUCT_ID, QUANTITY, TOTAL, SALE_DATE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, customerName);
            statement.setInt(2, productId);
            statement.setInt(3, quantity);
            statement.setDouble(4, total);
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
        }
        System.out.println("Sale record added for customer: " + customerName);
    }

    public void addColumn() throws SQLException {
        Statement stmt = connection.createStatement();
        String addColumn = "ALTER TABLE Products ADD COLUMN SIZE INT";
        stmt.executeUpdate(addColumn);
        System.out.println("Added column \"SIZE\"");
    }

    public void dropColumn() throws SQLException {
        Statement stmt = connection.createStatement();
        String dropColumn = "ALTER TABLE Products DROP COLUMN IMAGE_PATH";
        stmt.executeUpdate(dropColumn);
        System.out.println("Dropped column \"IMAGE_PATH\"");
    }

    // run if you want to reset a table and reinsert all data
    // replace table name in deleteData
    public void deleteData() throws SQLException {
        Statement stmt = connection.createStatement();
        String deleteData = "DELETE FROM Products";
        stmt.executeUpdate(deleteData);
        System.out.println("Deleted all data in table \"Products\"");
    }

    public Connection getConnection() {
        return connection;
    }

    public void commitChanges() {
        try {
            connection.commit();
            System.out.println("Commited changes");
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                DriverManager.getConnection("jdbc:derby:;shutdown=true");
            } catch (SQLException e) {
                if (e.getSQLState().equals("XJ015")) {
                    System.out.println("Database shut down normally.");
                } else {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
/*
            DatabaseManager db = new DatabaseManager();
            db.connect();
            db.createTables();
//                db.addColumn();
//                db.dropColumn();
//            db.deleteData();

            db.commitChanges();
            db.disconnect();
*/
             



            OnlineStore store = new OnlineStore();
            // Used to add products to database. Only need to run once.

            store.addShoes(new Shoes(1, "Air Jordan 1", 150, 10));
            store.addShoes(new Shoes(2, "Panda Dunk Low", 120, 9));
            store.addShoes(new Shoes(3, "New Balance 530", 100, 11));
            store.addShoes(new Shoes(4, "Astro Boots", 3000, 8));
            store.addShoes(new Shoes(5, "Gala Gaiters", 1700, 10));
            store.addShoes(new Shoes(6, "Lunar Glieds", 170, 7));
            store.addShoes(new Shoes(7, "EcoTreads", 90, 10));
            store.addShoes(new Shoes(8,"WalkWise", 129.99, 8));
            

//            store.createTables();
            // shutdown database
            store.dbCommit();
            store.dbShutdown();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
