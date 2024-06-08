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

    public DatabaseManager() {

    }

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
                + "IMAGE_PATH VARCHAR(255))";

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
        System.out.println("Tables created");
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
}
