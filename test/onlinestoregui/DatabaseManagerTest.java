/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package onlinestoregui;

import java.sql.Connection;
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
public class DatabaseManagerTest {
    
    public DatabaseManagerTest() {
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
     * Test of connect method, of class DatabaseManager.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        DatabaseManager instance = new DatabaseManager();
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTables method, of class DatabaseManager.
     */
    @Test
    public void testCreateTables() throws Exception {
        System.out.println("createTables");
        DatabaseManager instance = new DatabaseManager();
        instance.createTables();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColumn method, of class DatabaseManager.
     */
    @Test
    public void testAddColumn() throws Exception {
        System.out.println("addColumn");
        DatabaseManager instance = new DatabaseManager();
        instance.addColumn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropColumn method, of class DatabaseManager.
     */
    @Test
    public void testDropColumn() throws Exception {
        System.out.println("dropColumn");
        DatabaseManager instance = new DatabaseManager();
        instance.dropColumn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteData method, of class DatabaseManager.
     */
    @Test
    public void testDeleteData() throws Exception {
        System.out.println("deleteData");
        DatabaseManager instance = new DatabaseManager();
        instance.deleteData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnection method, of class DatabaseManager.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        DatabaseManager instance = new DatabaseManager();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disconnect method, of class DatabaseManager.
     */
    @Test
    public void testDisconnect() throws Exception {
        System.out.println("disconnect");
        DatabaseManager instance = new DatabaseManager();
        instance.disconnect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DatabaseManager.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        DatabaseManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
