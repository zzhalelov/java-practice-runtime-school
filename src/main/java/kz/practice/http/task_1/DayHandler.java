package kz.practice.http.task_1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class DayHandler implements HttpHandler {
    private static final String[] DAYS = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private static final Random random = new Random();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Началась обработка /day запроса от клиента.");

        String randomize = DAYS[random.nextInt(DAYS.length)];

        exchange.sendResponseHeaders(200, 0);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(randomize.getBytes());
        }
    }
}