package kz.practice.http.task_4;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class PostsHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // получите информацию об эндпоинте, к которому был запрос
        Endpoint endpoint = getEndpoint(exchange.getRequestURI().getPath(), exchange.getRequestMethod());

        switch (endpoint) {
            case GET_POSTS: {
                writeResponse(exchange, "Получен запрос на получение постов", 200);
                break;
            }
            case GET_COMMENTS: {
                writeResponse(exchange, "Получен запрос на получение комментариев", 200);
                break;
            }
            case POST_COMMENT: {
                writeResponse(exchange, "Получен запрос на добавление комментария", 200);
                break;
            }
            default:
                writeResponse(exchange, "Такого эндпоинта не существует", 404);
        }
    }

    private Endpoint getEndpoint(String requestPath, String requestMethod) {
        // реализуйте этот метод
        Endpoint endpoint;
        if (requestPath.endsWith("posts") && requestMethod.equals("GET")) {
            endpoint = Endpoint.GET_POSTS;
        } else if (requestMethod.equals("GET") && requestPath.endsWith("comments")) {
            endpoint = Endpoint.GET_COMMENTS;
        } else if (requestMethod.equals("POST") && requestPath.endsWith("comments")) {
            endpoint = Endpoint.POST_COMMENT;
        } else {
            endpoint = Endpoint.UNKNOWN;
        }
        return endpoint;
    }

    private void writeResponse(HttpExchange exchange,
                               String responseString,
                               int responseCode) throws IOException {
        /* Реализуйте отправку ответа, который содержит responseString в качестве тела ответа
        и responseCode в качестве кода ответа.
        Учтите, что если responseString — пустая строка, то её не нужно передавать в ответе. */
        exchange.sendResponseHeaders(responseCode, 0);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseString.getBytes());
        }
    }
}