package kz.practice.http.part_1.task_8;

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

        URI url = URI.create("https://api.apilayer.com/exchangerates_data/latest?base=EUR&symbols=KZT,USD&apikey=iISN69jOgAmSSuWq5GG68tko23CuqMLk");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if (!jsonElement.isJsonObject()) {
                    System.out.println("Ответ от сервера не соответствует ожидаемому.");
                    return;
                }
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonObject rates = jsonObject.get("rates").getAsJsonObject();
                double rateKZT = rates.get("KZT").getAsDouble();
                double rateUSD = rates.get("USD").getAsDouble();

                System.out.println("Стоимость евро в тенге: " + rateKZT + " KZT");
                System.out.println("Стоимость евро в долларах: " + rateUSD + " USD");
            } else {
                System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
            System.out.println("Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}