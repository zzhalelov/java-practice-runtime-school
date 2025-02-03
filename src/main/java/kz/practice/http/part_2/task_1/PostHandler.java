package kz.practice.http.part_2.task_1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class PostHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Началась обработка /day запроса от клиента.");
        String response = "";
        exchange.sendResponseHeaders(200, 0);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}