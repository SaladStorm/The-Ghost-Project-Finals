public class Main {
    public static void main(String[] args) {
        CurrencyRateService api = new CurrencyRateService();
        CurrencyConverterGUI gui = new CurrencyConverterGUI();
        
        Controller controller = new Controller(gui, api);
    }
}
