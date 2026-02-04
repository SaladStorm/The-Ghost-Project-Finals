public class Controller {
    private final CurrencyConverterGUI gui;
    private final CurrencyRateService service;

    public Controller(CurrencyConverterGUI gui, CurrencyRateService service)
    {
        // assign final fields first
        this.service = service;
        this.gui = gui;
        this.gui.startScreen1();
        for (int i = 0; i < service.currencies.length; i++) {
            this.gui.from.addItem(service.currencies[i]);
            this.gui.to.addItem(service.currencies[i]);
        }

        this.gui.Startbtn.addActionListener(e -> {
            this.gui.startScreen2();
        });

        this.gui.exitbtn.addActionListener(e -> {
            System.exit(0);
        });
    }
/*
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
*/
}
