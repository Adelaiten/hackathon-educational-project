package educational.hackathon.roleplay_school;

import com.sun.net.httpserver.HttpServer;
import educational.hackathon.roleplay_school.dao.AllDAOs;
import educational.hackathon.roleplay_school.handlers.LoginPageHandler;
import educational.hackathon.roleplay_school.handlers.Static;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.httpHandlers.student.StudentProfile;

import java.net.InetSocketAddress;

public class Server {
    private AllDAOs allDAOs;

    public Server(AllDAOs allDAOs){
        this.allDAOs = allDAOs;
    }

    public void run() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
            httpServer.createContext("/", new LoginPageHandler());
            httpServer.createContext("/studentProfile", new StudentProfile(allDAOs, new CookieHelper("")));
            httpServer.createContext("/static", new Static());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (Exception e) {
            System.out.println("Can not run server:");
            System.out.println(e.getMessage());
        }
    }
}
