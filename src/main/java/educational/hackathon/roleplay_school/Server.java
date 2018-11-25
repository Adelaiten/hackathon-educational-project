package educational.hackathon.roleplay_school;

import com.sun.net.httpserver.HttpServer;
import educational.hackathon.roleplay_school.handlers.LoginPageHandler;
import educational.hackathon.roleplay_school.handlers.Static;

import java.net.InetSocketAddress;

public class Server {
    public void run() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(5777), 0);
            httpServer.createContext("/", new LoginPageHandler());
            httpServer.createContext("/static", new Static());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (Exception e) {
            System.out.println("Can not run server:");
            System.out.println(e.getMessage());
        }
    }
}
