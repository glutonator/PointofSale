public class Scanner {
    private IScanner iScanner;

    public Scanner(IScanner iScanner) {
        this.iScanner = iScanner;
    }
//    public String find(String text) {
//        String tmp = this.iScanner.getBarCode(text);
//        return tmp;
//    }
    public String getBarCode() throws InvalidBarCodeException {
        String tmp =this.iScanner.getBarCode();
        return tmp;
    }
}
