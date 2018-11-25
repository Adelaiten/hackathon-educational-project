package educational.hackathon.roleplay_school.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class AbstractHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();
        String response = "<html><body>";
        List<String> cookies = httpExchange.getRequestHeaders().get("Cookie");
        if (method.equals("GET")) {
            response += "GET";
            response += " <br>" +
                    "<img src = '../static/image/1.png'>obrazek</img>" +
                    "<img src = '../static/image/2.png'>obrazek2</img>" +
                    "</body></html>";

        }
        if (method.equals("POST")) {
            response = "POST";
        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static void sendResponse(HttpExchange httpExchange, String path, String response) throws IOException {
        OutputStream os = httpExchange.getResponseBody();

        try {
            byte[] bs = response.getBytes();
            httpExchange.getResponseHeaders().set("Location", path);
            httpExchange.sendResponseHeaders(302, bs.length);
            os.write(bs);
            os.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void sendRedirectResponse(HttpExchange httpExchange, String path, String response) throws IOException {
        OutputStream os = httpExchange.getResponseBody();
        try {
            byte[] bs = response.getBytes();
            httpExchange.getResponseHeaders().set("Location", path);
            httpExchange.sendResponseHeaders(302, -1);
            os.write(bs);
            os.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
