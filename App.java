import ghostproject.CurrencyConverterGUI;
import ghostproject.CurrencyRateService;
import ghostproject.JsonParser;

public class App {
    public static CurrencyConverterGUI gui = new CurrencyConverterGUI();
    public static CurrencyRateService service = new CurrencyRateService();
    public static JsonParser parser = new JsonParser();
    public static void main(String[] args)
    {
        
        String currencyJson = service.getAllCurrencies();
        if (currencyJson != null) {
            String[] codes = parser.getCurrencyCodes(currencyJson);
            for (int e =0; e < codes.length; e++) {
                gui.from.addItem(codes[e]);
                gui.to.addItem(codes[e]);
            }
        }


        // assign final fields first
        gui.startScreen1();
        for (int i = 0; i < 0; i++) {
            //gui.from.addItem(service.currencies[i]);
            //gui.to.addItem(service.currencies[i]);
        }

        gui.Startbtn.addActionListener(e -> {
            gui.startScreen2();
            gui.switchbtn.addActionListener(switchEvent -> {
                Object fromSelected = gui.from.getSelectedItem();
                Object toSelected = gui.to.getSelectedItem();
                gui.from.setSelectedItem(toSelected);
                gui.to.setSelectedItem(fromSelected);
                String temp = gui.fromtf.getText();
                gui.fromtf.setText(gui.totf.getText());
                gui.totf.setText(temp);
                gui.convertbtn.doClick();
            });
        });

        gui.exitbtn.addActionListener(e -> {
            System.exit(0);
        });
        gui.convertbtn.addActionListener(e -> {
            try {
                gui.totf.setText("0.00");
                String from = gui.from.getSelectedItem().toString();
                String to = gui.to.getSelectedItem().toString();
                double amount = Double.parseDouble(gui.fromtf.getText());

                service.setBase(from);
                service.setTo(to);
                
                String tempjson = service.getAllCurrencies();
                String fromcurrencyName = parser.getCurrencyName(tempjson, from);
                String toCurrencyName = parser.getCurrencyName(tempjson, to);
                gui.label2.setText("Convert from: " + fromcurrencyName);
                gui.label3.setText("Convert to: " + toCurrencyName);
                
                // Pass the 'to' variable to make the parser dynamic
                double rate = parser.getRate(service.fetchRateJson(from, to), to);
                
                double convertedAmount = amount * rate;
                gui.totf.setText(String.format("%.2f", convertedAmount));
                gui.frame2.pack();
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        });
    }
}
