import ghostproject.CurrencyConverterGUI;
import ghostproject.CurrencyRateService;
import ghostproject.JsonParser;

public class App {
    public static CurrencyConverterGUI gui = new CurrencyConverterGUI();
    public static CurrencyRateService service = new CurrencyRateService();
    public static JsonParser parser = new JsonParser();
    public static String[] currencyCodes;
    public static String currencyJson = service.getAllCurrencies();
    public static void main(String[] args)
    {
        if (currencyJson.isEmpty()) {
            System.err.println("Failed to fetch currency data");
            System.exit(1);
        } else {
            currencyCodes = parser.getCurrencyCodes(currencyJson);
            for (int e =0; e < currencyCodes.length; e++) {
            gui.from.addItem(currencyCodes[e]);
            gui.to.addItem(currencyCodes[e]);
            }
        }

        gui.startScreen1();

        gui.Startbtn.addActionListener(ActionEvent -> {
            gui.startScreen2();
        });

        gui.exitbtn.addActionListener(ActionEvent -> {
            System.exit(0);
        });
        
        gui.convertbtn.addActionListener(ActionEvent -> {
            gui.totf.setText("0.00");
            if (gui.fromtf.getText().isEmpty()) {
                gui.frame2.pack();
                return;
            }
            updateL();
                
            gui.frame2.pack();
        });

        gui.switchbtn.addActionListener(ActionEvent -> {
                Object fromSelected = gui.from.getSelectedItem();
                Object toSelected = gui.to.getSelectedItem();
                gui.from.setSelectedItem(toSelected);
                gui.to.setSelectedItem(fromSelected);
                String temp = gui.fromtf.getText();
                gui.fromtf.setText(gui.totf.getText());
                gui.totf.setText(temp);
                gui.convertbtn.doClick();
                gui.frame2.pack();
        });

    }
    public static void updateL() {
        
        String from = gui.from.getSelectedItem().toString();
        String to = gui.to.getSelectedItem().toString();
        double amount = Double.parseDouble(gui.fromtf.getText());

        service.setBase(from);
        service.setTo(to);

        String fromcurrencyName = parser.getCurrencyName(currencyJson, from);
        String toCurrencyName = parser.getCurrencyName(currencyJson, to);
        gui.label2.setText("Convert from: " + fromcurrencyName);
        gui.label3.setText("Convert to: " + toCurrencyName);
        
        if (from.equals(to)) {
            gui.totf.setText(Double.toString(amount));
            gui.frame2.pack();
            return;
        }
        
        double rate = parser.getRate(service.fetchRateJson(), to);
        double convertedAmount = amount * rate;
        gui.totf.setText(String.format("%.2f", convertedAmount));
    }
}
