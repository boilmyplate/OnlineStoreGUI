/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package onlinestoregui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author emm
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({onlinestoregui.OnlineStoreTest.class, onlinestoregui.BuyShoesTest.class, onlinestoregui.ProductTest.class, onlinestoregui.SaleRecordTest.class, onlinestoregui.OnlineStoreGUITest.class, onlinestoregui.CartItemTest.class, onlinestoregui.DatabaseManagerTest.class, onlinestoregui.CartTest.class, onlinestoregui.ShoesTest.class})
public class OnlinestoreguiSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
