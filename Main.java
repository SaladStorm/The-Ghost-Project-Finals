public class Main {
    public static void main(String[] args) {
        CurrencyRateService api = new CurrencyRateService();
        CurrencyConverterGUI gui = new CurrencyConverterGUI();
        gui.startScreen1();
        gui.startScreen2();
        Controller controller = new Controller(gui, api);
    }
}
