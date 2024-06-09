package onlinestoregui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 *
 * @Author peter
 */
public class BuyShoesTest {

    private ByteArrayOutputStream outContent;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void testGetQuantityValidInput() throws Exception {
        String input = "3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Method method = BuyShoes.class.getDeclaredMethod("getQuantity", Scanner.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, scanner);

        assertEquals(3, result);
    }

    @Test
    public void testGetQuantityInvalidInput() throws Exception {
        String input = "abc\n0\n2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Method method = BuyShoes.class.getDeclaredMethod("getQuantity", Scanner.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, scanner);

        assertEquals(2, result);
        assertTrue(outContent.toString().contains("Please input a number"));
    }

    @Test
    public void testSaveSaleRecordToFile() throws Exception {
        String saleRecord = "Test Sale Record";

        Method method = BuyShoes.class.getDeclaredMethod("saveSaleRecordToFile", String.class);
        method.setAccessible(true);
        method.invoke(null, saleRecord);

        File logFile = new File("SalesRecord.txt");
        assertTrue(logFile.exists());

        Scanner fileScanner = new Scanner(logFile);
        boolean found = false;
        while (fileScanner.hasNextLine()) {
            if (fileScanner.nextLine().equals(saleRecord)) {
                found = true;
                break;
            }
        }
        fileScanner.close();
        assertTrue(found);

        // Clean up the file after test
        logFile.delete();
    }
}
