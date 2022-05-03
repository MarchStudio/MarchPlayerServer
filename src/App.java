import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("Welcome! MarchPlayerServer Version %s.\n", My.Version);
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/", new DirectVisit());
        server.start();
    }

    static  class DirectVisit implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.printf("[%s]%s connected.\n", My.TimeOfDay(), exchange.getRemoteAddress());
            String response = "MarchPlayerServer\nVersion " + My.Version;
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}