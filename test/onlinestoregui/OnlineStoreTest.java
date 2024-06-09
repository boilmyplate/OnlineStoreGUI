/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package onlinestoregui;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emm
 */
public class OnlineStoreTest {
    
    public OnlineStoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addShoes method, of class OnlineStore.
     */
    @Test
    public void testAddShoes() throws Exception {
        System.out.println("addShoes");
        Shoes shoe = null;
        OnlineStore instance = new OnlineStore();
        instance.addShoes(shoe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducts method, of class OnlineStore.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        OnlineStore instance = new OnlineStore();
        List<Product> expResult = null;
        List<Product> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToCart method, of class OnlineStore.
     */
    @Test
    public void testAddToCart() {
        System.out.println("addToCart");
        Product product = null;
        int quantity = 0;
        OnlineStore instance = new OnlineStore();
        instance.addToCart(product, quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCart method, of class OnlineStore.
     */
    @Test
    public void testGetCart() {
        System.out.println("getCart");
        OnlineStore instance = new OnlineStore();
        Cart expResult = null;
        Cart result = instance.getCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveRecords method, of class OnlineStore.
     */
    @Test
    public void testSaveRecords() {
        System.out.println("saveRecords");
        String customerName = "";
        OnlineStore instance = new OnlineStore();
        instance.saveRecords(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidProduct method, of class OnlineStore.
     */
    @Test
    public void testIsValidProduct() {
        System.out.println("isValidProduct");
        int index = 0;
        OnlineStore instance = new OnlineStore();
        boolean expResult = false;
        boolean result = instance.isValidProduct(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearCart method, of class OnlineStore.
     */
    @Test
    public void testClearCart() {
        System.out.println("clearCart");
        OnlineStore instance = new OnlineStore();
        instance.clearCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dbShutdown method, of class OnlineStore.
     */
    @Test
    public void testDbShutdown() throws Exception {
        System.out.println("dbShutdown");
        OnlineStore instance = new OnlineStore();
        instance.dbShutdown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
