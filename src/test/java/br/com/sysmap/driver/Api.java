package br.com.sysmap.driver;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class Api {

    public static String getLatLon(String cidade) {
        String retorno = null;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet get = new HttpGet("http://api.openweathermap.org/geo/1.0/direct?q="+ cidade +"&appid=7c063ca2d37c75de715cdc148c9b6151");
            HttpResponse response = client.execute(get);
            String resp = EntityUtils.toString(response.getEntity());
            System.out.println(resp);
            JSONObject obj = new JSONObject(resp.replace("[","").replace("]",""));
            System.out.println(obj.getBigDecimal("lat"));
            System.out.println(obj.getBigDecimal("lon"));
            retorno = "lat="
                    .concat(String.valueOf(obj.get("lat")))
                    .concat("&lon=")
                    .concat(String.valueOf(obj.get("lon")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;

    }
    public static String currentWeather(String cidade) {
        String retorno = null;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String uri = "https://api.openweathermap.org/data/2.5/weather?"+getLatLon(cidade)+"&appid=7c063ca2d37c75de715cdc148c9b6151";
            HttpGet get = new HttpGet(uri);
            HttpResponse response = client.execute(get);
            String resp = EntityUtils.toString(response.getEntity());
            JSONObject obj = new JSONObject(resp);

            System.out.println(obj.getJSONObject("main"));
            JSONObject main = obj.getJSONObject("main");
            System.out.println(main.get("temp"));
            retorno = String.valueOf(obj.get("name"));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;

    }

}
