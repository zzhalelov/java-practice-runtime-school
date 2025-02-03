package kz.practice.http.part_1.task_7;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Practice {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://ipwhois.app/json/194.187.245.10?lang=ru");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if (!jsonElement.isJsonObject()) {
                    System.out.println("Ответ сервера не соответсвует ожидаемому");
                    return;
                }
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                String country = jsonObject.get("country").getAsString();
                String city = jsonObject.get("city").getAsString();
                double latitude = jsonObject.get("latitude").getAsDouble();

                System.out.println("Страна " + country);
                System.out.println("Город " + city);
                System.out.println("Широта " + latitude);
            } else {
                System.out.println("Чтоөто пошло не так/ Сервер вернул код состояния " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Во время выполнения запроса ресурса по url-адресу: '" + url + "' возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}