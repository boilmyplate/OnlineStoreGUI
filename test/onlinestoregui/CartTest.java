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
public class CartTest {
    
    public CartTest() {
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
     * Test of addItem method, of class Cart.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        CartItem item = null;
        Cart instance = new Cart();
        instance.addItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Cart.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Cart instance = new Cart();
        List<CartItem> expResult = null;
        List<CartItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearItems method, of class Cart.
     */
    @Test
    public void testClearItems() {
        System.out.println("clearItems");
        Cart instance = new Cart();
        instance.clearItems();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
