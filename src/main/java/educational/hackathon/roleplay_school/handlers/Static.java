package educational.hackathon.roleplay_school.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.helpers.MimeTypeResolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

public class Static implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        URI uri = httpExchange.getRequestURI();
        System.out.println("requested uri: " + uri.getPath());
        String path = "." + uri.getPath();

        ClassLoader cl = getClass().getClassLoader();
        URL fileURL = cl.getResource(path);

        if (fileURL == null) {
            System.out.println("No such file!");
        } else {
            sendFile(httpExchange, fileURL);
        }
    }

    public void sendFile(HttpExchange httpExchange, URL fileURL) throws IOException {
        File file = new File(fileURL.getFile());
        MimeTypeResolver resolver = new MimeTypeResolver(file);
        String mime = resolver.getMimeType();

        httpExchange.getResponseHeaders().set("Content-Type", mime);
        httpExchange.sendResponseHeaders(200, 0);

        OutputStream os = httpExchange.getResponseBody();

        FileInputStream fis = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fis.read(buffer)) >= 0) {
            os.write(buffer, 0, count);
        }
        os.close();

    }
}
