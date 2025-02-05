package kz.practice.http.part_2.task_4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Реализуйте удаление данных через DELETE-запрос
//Отправьте DELETE-запрос на https://jsonplaceholder.typicode.com/posts/1.
//Проверьте статус-код (должен быть 200 или 204).
public class Practice {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://jsonplaceholder.typicode.com/posts/1");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Server response: " + response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}