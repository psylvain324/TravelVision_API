package com.travel.vision.api.services.ServiceImpl;

import com.travel.vision.api.services.BaseService;
import com.travel.vision.api.services.CurrencyService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class CurrencyServiceImpl extends BaseService implements CurrencyService {
    @Value("${currency.layer.key}")
    public static String ACCESS_KEY;
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    
    @Override
    public Double getCurrencyQuote(String from, String to) {
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        String search = from + to;
        Double quote = null;

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            quote = exchangeRates.getJSONObject("quotes").getDouble(search);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return quote;
    }
}
