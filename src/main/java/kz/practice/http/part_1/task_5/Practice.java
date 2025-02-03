package kz.practice.http.part_1.task_5;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Practice {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/posts", new PostHandler());
        httpServer.start();
        System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
    }
}