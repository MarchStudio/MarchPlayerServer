import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class NetHttp {

    private static void createContext(HttpServer server, String path, String RequestName) {
        server.createContext(path, new response(RequestName));
    }

    public static void startHttp() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(My.httpPort), 0);
        createContext(server, "/", Requests.Info);
        createContext(server, "/UdpPort", Requests.UdpPort);
        createContext(server, "/PlayList", Requests.PlayList);
        server.start();
        Log.print(String.format("HttpServer started at port %d.", My.httpPort));
    }

    static class response implements HttpHandler {

        String request;

        public response(String request) {
            this.request = request;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Log.print(String.format("%s request for \"%s\".",
                    exchange.getRemoteAddress(),
                    this.request));
            String response = "";
            switch (this.request) {
                case Requests.Info:
                    response = String.format("<title>MarchPlayerServer</title><body>MarchPlayerServer<br>Version %s.<br>Running on %s.</body>", My.Version, System.getProperty("os.name"));
                    break;
                case Requests.UdpPort:
                    response = "" + My.udpPort;
                    break;
                case Requests.PlayList:
                    response = Playlist.getAllUrls();
                    break;
                default:
                    response = null;
                    break;
            }
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}