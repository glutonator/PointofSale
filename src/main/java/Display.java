public class Display {
    private IDisplay iDisplay;

    public Display(IDisplay iDisplay) {
        this.iDisplay = iDisplay;
    }
    public void show(String text) {
        this.iDisplay.show(text);
        System.out.println(text);
    }
}
