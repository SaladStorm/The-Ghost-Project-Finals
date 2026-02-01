
import java.io.IOException;
import java.net.URI;
import java.net.http.*;


public final class CurrencyRateService
{
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    String base, to;
    double amount;  

    public double convert(String from, String to, double amount)
    {
        setBase(from);
        setTo(to);
        setAmount(amount);
        return rates();
    }
    private double rates()
    {
        return 0.0;
    }
    public String fetchData()
    {
         client = HttpClient.newHttpClient();
         request = HttpRequest.newBuilder()
                 .uri(URI.create(getURL(getBase(), getTo())))
                 .build();
         try
        {
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
             System.out.println(response.body());
         }
         catch (IOException | InterruptedException e)
         {
             System.err.println("Error " + e.getMessage());
         }
        
         return response.body();
    }
    private String getURL(String base, String to)
    {
        return "https://api.frankfurter.dev/v1/latest?base=" + base + "&symbols=" + to;
    }
    private void setBase(String base)
    {
        this.base = base;
    }
    public void setTo(String to)
    {
        this.to = to;
    }
    public String getBase()
    {
        return base;
    }
    public String getTo()
    {
        return to;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
}   
