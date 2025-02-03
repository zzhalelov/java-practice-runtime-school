package kz.practice.http.part_2.task_1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Создайте Java-программу, которая отправляет GET-запрос на публичный API
public class Practice {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        URI url = URI.create("https://jsonplaceholder.typicode.com/posts/1");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Server response: " + response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
    }
}