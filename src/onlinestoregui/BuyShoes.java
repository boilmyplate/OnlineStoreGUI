/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author petersun
 */
public class BuyShoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineStore sneakerStore = new OnlineStoreGUI();

        sneakerStore.displayWelcomeMessage();
        sneakerStore.displayProducts();

        int shoeNumber = getShoeNumber(scanner, sneakerStore);
        int quantity = getQuantity(scanner);

        // Retrieve the chosen shoe
        Product chosenShoe = sneakerStore.chooseProduct(shoeNumber);

        // Perform checkout
        double totalPrice = sneakerStore.checkout(chosenShoe, quantity);

        // Ask for customer details
        System.out.print("\nPlease enter your name: ");
        String name = scanner.nextLine();

        // Save sale record
        SaleRecord saleRecord = new SaleRecord(name, chosenShoe, quantity, totalPrice);
        sneakerStore.saveSaleRecord(saleRecord);

        System.out.printf("\nThank you for shopping with us %s! Please see your receipt below!\n\n", name);
        
        System.out.println(sneakerStore.getSaleRecordAsString(0));

        saveSaleRecordToFile(sneakerStore.getSaleRecordAsString(0));

        scanner.close();
    }

    private static int getShoeNumber(Scanner scanner, OnlineStore sneakerStore) {
        int shoeNumber = 0;
        do {
            System.out.print("Please choose the id of the shoe you want to buy: ");
            try {
                shoeNumber = scanner.nextInt();
                scanner.nextLine();
                if (!sneakerStore.isValidProduct(shoeNumber)) {
                    System.out.println("Enter a number between 1-3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a number");
                scanner.nextLine();
            }
        } while (!sneakerStore.isValidProduct(shoeNumber));
        return shoeNumber;
    }

    private static int getQuantity(Scanner scanner) {
        int quantity = 0;
        do {
            System.out.print("Please enter the quantity you want to buy: ");
            try {                
                quantity = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please input a number");
                scanner.nextLine();
            }
        } while (quantity <= 0);
        return quantity;
    }

    private static void saveSaleRecordToFile(String saleRecord) {
        try {
            File logFile = new File("SalesRecord.txt");

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileWriter fw = new FileWriter(logFile, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(saleRecord);
            bw.newLine(); // Add a newline for readability
            bw.close();

        } catch (IOException e) {
            System.err.println("Error saving sale record to file: " + e.getMessage());
        }
    }
}
