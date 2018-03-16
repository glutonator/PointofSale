import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ScannerTest {

    @Mock
    private IScanner iScannerMock;
    @InjectMocks
    private Scanner scanner;

    @Mock
    private IDatabase iDatabaseMock;
    @InjectMocks
    private Database database;

    @Mock
    private IDisplay iDisplayMock;
    @InjectMocks
    private Display display;

    @Before
    public void beforeEachTest() {
        iScannerMock = Mockito.mock(IScanner.class);
        scanner = new Scanner(iScannerMock);

        iDatabaseMock = Mockito.mock(IDatabase.class);
        database = new Database(iDatabaseMock);

        iDisplayMock =Mockito.mock(IDisplay.class);
        display = new Display(iDisplayMock);
    }

    //zrobić kilka f testowych kazda na inny input
    //pozniej trzeba uwzglednic, ze rozne komunikaty sa na drukarce
    //pozniej exit uwazxglednic

    //    @Test
//    public void foundInDatabase() {
//        //IScanner iScannerMock;
//        //Scanner scanner;
//        String text = "12345a";
//        //iScannerMock = Mockito.mock(IScanner.class);
//        //scanner= new Scanner(iScannerMock);
//
//        when(iScannerMock.getBarCode(text)).thenReturn("ppp");
//        String actual = scanner.find(text);
//        // System.out.println(actual);
//        assertEquals("ppp", actual);
////        verify(iScannerMock,never()).getBarCode(text);
//    }

    @Test
    public void notcorrectBarCode() throws InvalidBarCodeException, ProductNotFoundException {
        String text = "";
        when(iScannerMock.getBarCode()).thenThrow(new InvalidBarCodeException());
        try {
            String actualBarCode = scanner.getBarCode();

            //to się już nie wykona chyba
            assertEquals(text, actualBarCode);
            //database
            when(iDatabaseMock.searchInDatabase(actualBarCode)).thenReturn("Produkt1");
            String actualProduct = database.searchInDatabase(actualBarCode);

            assertEquals("Produkt1", actualProduct);
            //verify(iDatabase,atLeastOnce()).searchInDatabase(actualBarCode);
            verify(iScannerMock, atLeastOnce()).getBarCode();
        }
        catch (InvalidBarCodeException e) {
            System.out.println(e);
            display.show("Invalid bar-code");

        }

    }
    @Test
    public void correctBarCode() throws InvalidBarCodeException, ProductNotFoundException {
        String text = "12345c";
        when(iScannerMock.getBarCode()).thenReturn(text);
        String actualBarCode = scanner.getBarCode();
        assertEquals(text, actualBarCode);
        //database
        when(iDatabaseMock.searchInDatabase(actualBarCode)).thenReturn("Produkt1");
        String actualProduct = database.searchInDatabase(actualBarCode);

        assertEquals("Produkt1", actualProduct);
        //verify(iDatabase,atLeastOnce()).searchInDatabase(actualBarCode);
        verify(iScannerMock, atLeastOnce()).getBarCode();
    }

    @Test
    public void foundInDatabase() throws InvalidBarCodeException, ProductNotFoundException {
        String text = "12345a";
        when(iScannerMock.getBarCode()).thenReturn(text);
        String actualBarCode = scanner.getBarCode();
        assertEquals(text, actualBarCode);
        //database
        when(iDatabaseMock.searchInDatabase(actualBarCode)).thenReturn("Produkt1");
        String actualProduct = database.searchInDatabase(actualBarCode);

        assertEquals("Produkt1", actualProduct);
        //verify(iDatabase,atLeastOnce()).searchInDatabase(actualBarCode);
        verify(iScannerMock, atLeastOnce()).getBarCode();
        //iDisplayMock.show(actualProduct);
        display.show(actualProduct);
        verify(iDisplayMock,never()).show(actualProduct);

        //when(iDisplayMock.show();)
    }

    @Test //(expected = NotFoundException.class)
    public void notfoundInDatabase() throws InvalidBarCodeException, ProductNotFoundException {
        String text = "12345b";
        when(iScannerMock.getBarCode()).thenReturn(text);
        String actualBarCode = scanner.getBarCode();
        assertEquals(text, actualBarCode);
        //database
        when(iDatabaseMock.searchInDatabase(actualBarCode)).thenThrow(new ProductNotFoundException());
        //String actualProduct = database.searchInDatabase(actualBarCode);

        try {
            String actualProduct = database.searchInDatabase(actualBarCode);
        } catch (ProductNotFoundException e) {
            //tutaj drukowanie na ekran błedu
            System.out.println(e);
            display.show("Product not found");

        }
    }
}