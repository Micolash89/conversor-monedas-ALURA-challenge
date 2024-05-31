package service;

import com.google.gson.Gson;
import entitiesDTO.MonedaDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiRequestService {

    private final String URL_STR = "https://v6.exchangerate-api.com/v6/5dfa0a966f437828cabdf14c/latest/";

    public Double conectUrl(String moneda, String keyMoneda) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.URL_STR + moneda))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
//        MonedaDTO monedaList = gson.fromJson(response.body(), MonedaDTO.class);
            // System.out.println(monedaList);
            MonedaDTO monedaDTO = new Gson().fromJson(response.body(), MonedaDTO.class);

            return monedaDTO.conversion_rates().get(keyMoneda);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
