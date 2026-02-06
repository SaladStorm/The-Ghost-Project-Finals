package ghostproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CurrencyRateService
{
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request;
    HttpResponse<String> response;
    String base, to;
    double amount;  

    public CurrencyRateService()
    {
      //
    }

    // Fetches the list of all currency codes to fill the jcomboboxes
    public String getAllCurrencies() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.frankfurter.dev/v1/currencies"))
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
    
    public String fetchRateJson(String base, String target) {
        String url = "https://api.frankfurter.dev/v1/latest?base=" + base + "&symbols=" + target;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
    public void setBase(String from) {this.base = from;}
    public void setTo(String to) {this.to = to;}
}