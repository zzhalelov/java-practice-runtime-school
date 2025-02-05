package kz.practice.http.part_2.task_3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Реализуйте обновление данных с помощью PUT-запроса
//Измените существующий пост (/posts/1) с новыми данными.
//Выведите статус-код ответа и обновленный объект.
public class Practice {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://jsonplaceholder.typicode.com/posts/1");
        String json = """
                {
                    "title: "updated title",
                    "body": " updated body",
                    "userId": 2
                }
                """;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
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