/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinestoregui;

/**
 *
 * @author petersun
 */
public interface OnlineStore {
    void displayWelcomeMessage();
    void displayProducts();
    Product chooseProduct(int productId);
    double checkout(Product product, int quantity);
    void saveSaleRecord(SaleRecord record);
    String getSaleRecordAsString(int index);
    boolean isValidProduct(int productId);
}