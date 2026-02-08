package ghostproject;
import java.util.Set;
import com.google.gson.*;

public class JsonParser {
    public Gson gson = new Gson();
    
    public String[] getCurrencyCodes(String json) {
        JsonObject obj = gson.fromJson(json, JsonObject.class);
        Object[] keys = obj.keySet().toArray();
        String[] codes = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            codes[i] = keys[i].toString();
        }
        return codes;
    }
    
    public String getCurrencyName(String json, String code) {
        JsonObject obj = gson.fromJson(json, JsonObject.class);
        return obj.get(code).getAsString();
    }

    public double getRate(String json, String targetKey) {
        JsonObject root = gson.fromJson(json, JsonObject.class);
        return root.getAsJsonObject("rates").get(targetKey).getAsDouble();
    }

}
