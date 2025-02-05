package kz.practice.http.part_2.task_2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Напишите программу, выполняющую POST-запрос
//Отправьте новый пост на https://jsonplaceholder.typicode.com/posts.
//Передайте JSON-объект с полями title, body, userId.
//Выведите ответ сервера.
public class Practice {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://jsonplaceholder.typicode.com/posts");
        String json = """
                {
                    "title: "title",
                    "body": "body",
                    "userId": 1
                }
                """;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Код статуса: " + response.statusCode());
            System.out.println("Ответ сервера: \n" + response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}