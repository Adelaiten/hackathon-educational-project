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
        if(method.equals("GET")){
            response += "GET";
            response += " <br>" +
                    "<img src = '../static/image/1.png'>obrazek</img>" +
                    "</body></html>";

        }
        if(method.equals("POST")){
            response = "POST";
        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
