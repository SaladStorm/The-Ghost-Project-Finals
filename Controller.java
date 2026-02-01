public class Controller {
    private final CurrencyConverterGUI gui;
    private final CurrencyRateService service;

    public Controller(CurrencyConverterGUI gui, CurrencyRateService service) {
        this.gui = gui;
        this.service = service;
    }

    private void convertCurrency() {
        try {
            String base = gui.from.getSelectedItem().toString();
            String to = gui.to.getSelectedItem().toString();

            String result = service.fetchData();
            System.out.println(result);
            } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
