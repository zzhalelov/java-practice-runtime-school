package kz.practice.http.part_1.task_3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "";

        String method = httpExchange.getRequestMethod();

        switch (method) {
            case "POST" -> {
                String path = httpExchange.getRequestURI().getPath();

                String[] splitStrings = path.split("/");

                String profession = splitStrings[2];
                String name = splitStrings[3];

                List<String> wishGoodDay = httpExchange.getRequestHeaders().get("X-Wish-Good-Day");
                if ((wishGoodDay != null) && (wishGoodDay.contains("true"))) {
                    response = String.format("Доброе утро, " + profession + name + " Хорошего дня!");
                }
            }
            case "GET" -> {
                response = "Здравствуйте!";
            }
            default -> {
                response = "Некорректный метод!";
            }
        }

        httpExchange.sendResponseHeaders(200, 0);
        try (OutputStream os = httpExchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}