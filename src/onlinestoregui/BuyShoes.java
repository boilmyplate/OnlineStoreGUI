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
            bw.newLine(); 
            bw.close();

        } catch (IOException e) {
            System.err.println("Error saving sale record to file: " + e.getMessage());
        }
    }
}
