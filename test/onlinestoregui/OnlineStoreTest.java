package onlinestoregui;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OnlineStoreTest {

    private OnlineStore instance;
    private DatabaseManager mockDbManager;

    public OnlineStoreTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        instance = new OnlineStore();
        
        mockDbManager = new DatabaseManager() {
            @Override
            public void connect() {

            }

            @Override
            public void disconnect() {

            }

            @Override
            public Connection getConnection() {
                return null; 
            }

            @Override
            public void commitChanges() {
                
            }
        };

    
        Field dbManagerField = OnlineStore.class.getDeclaredField("dbManager");
        dbManagerField.setAccessible(true);
        dbManagerField.set(instance, mockDbManager);
    }

    @After
    public void tearDown() {
        instance = null;
    }
    
    
    //Test of getProducts method, of class OnlineStore.
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        List<Product> result = instance.getProducts();
        assertNotNull(result);
    }


    //Test of addToCart method, of class OnlineStore.

    @Test
    public void testAddToCart() {
        System.out.println("addToCart");
        Product product = new Shoes(2, "Another Shoe", 79.99, 40);
        int quantity = 2;
        instance.addToCart(product, quantity);
        Cart cart = instance.getCart();
        List<CartItem> items = cart.getItems();
        assertTrue(items.stream().anyMatch(item -> item.getProduct().equals(product) && item.getQuantity() == quantity));
    }

    
    //Test of getCart method, of class OnlineStore.
    @Test
    public void testGetCart() {
        System.out.println("getCart");
        Cart result = instance.getCart();
        assertNotNull(result);
        assertTrue(result.getItems().isEmpty()); // Assuming the cart is initially empty
    }

    
    //Test of saveRecords method, of class OnlineStore.
    @Test
    public void testSaveRecords() {
        System.out.println("saveRecords");
        Product product = new Shoes(3, "Sample Shoe", 59.99, 38);
        instance.addToCart(product, 1);
        String customerName = "Test Customer";
        instance.saveRecords(customerName);
    }

    //Test of isValidProduct method, of class OnlineStore.
    @Test
    public void testIsValidProduct() {
        System.out.println("isValidProduct");
        int validIndex = 0;
        int invalidIndex = -1;
        assertTrue(instance.isValidProduct(validIndex));
        assertFalse(instance.isValidProduct(invalidIndex));
    }


    //Test of clearCart method, of class OnlineStore.

    @Test
    public void testClearCart() {
        System.out.println("clearCart");
        Product product = new Shoes(4, "Clear Cart Shoe", 49.99, 39);
        instance.addToCart(product, 1);
        instance.clearCart();
        assertTrue(instance.getCart().getItems().isEmpty());
    }


     //Test of dbShutdown method, of class OnlineStore.
    @Test
    public void testDbShutdown() throws Exception {
        System.out.println("dbShutdown");
        instance.dbShutdown();
    }
}
