/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinestoregui;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author petersun
 */
public class OnlineStoreGUI implements OnlineStore {
    
    private Map<Integer, Product> products;
    private List<SaleRecord> salesRecords;
    
    public OnlineStoreGUI() {
        products = new HashMap<>();
        salesRecords = new ArrayList<>();
        products.put(1, new Shoes(1, "Air Jordan 1", 179.50, "10"));
        products.put(2, new Shoes(2, "Panda Dunk Low", 149.99, "9"));
        products.put(3, new Shoes(3, "New Balance 530", 165.50, "11"));
    }

    @Override
    public void displayProducts() {
        System.out.println("The shoes we have:");
        for (Product product : products.values()) {
            System.out.println(" ______________________");
            System.out.println("|    " + product.getName() + "    |");
            System.out.println("|______________________|");
            System.out.println("|            ___       |");
            System.out.println("|      ___ /`\"\"\"`8-.__ |");
            System.out.println("|    /`\"\"\"`8-.__._    )|");
            System.out.println("|    \\   ._     ) \"\"\"\" |");
            System.out.println("|    \"\"\"\"  \"\"\"\"\"\"\"     |");
            System.out.println("|______________________|");

            System.out.println("\n  (" + product.getId() + ") " + product.getName());
            System.out.printf("     Price: $%.2f\n", product.getPrice());
            System.out.println("________________________");
        }
    }

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to PJ Sneaker Store");
    }

    @Override
    public Product chooseProduct(int productId) {
        return products.get(productId);
    }

    @Override
    public double checkout(Product chosenProduct, int quantity) {
        double totalPrice = chosenProduct.getPrice() * quantity;
        System.out.printf("Total price for %d %s(s): $%.2f\n", quantity, chosenProduct.getName(), totalPrice);
        return totalPrice;
    }

    @Override
    public void saveSaleRecord(SaleRecord record) {
        salesRecords.add(record);
    }

    @Override
    public String getSaleRecordAsString(int index) {
        return salesRecords.get(index).toString();
    }

    @Override
    public boolean isValidProduct(int productId) {
        return products.containsKey(productId);
    }
}