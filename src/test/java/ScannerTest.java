import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ScannerTest {

    @Mock
    private IScanner iScannerMock;
    @InjectMocks
    private Scanner scanner;

    @Before
    public void beforeEachTest() {
        iScannerMock = Mockito.mock(IScanner.class);
        scanner = new Scanner(iScannerMock);
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
    public void foundInDatabase() {
        String text = "12345a";
        when(iScannerMock.getBarCode()).thenReturn(text);
        String actual = scanner.getBarCode();
        assertEquals("ppp", actual);
    }

    @Test
    public void notfoundInDatabase() {
        String text = "12345a";
        when(iScannerMock.getBarCode()).thenReturn(text);
        String actual = scanner.getBarCode();
        assertEquals("ooo",actual);
    }
}