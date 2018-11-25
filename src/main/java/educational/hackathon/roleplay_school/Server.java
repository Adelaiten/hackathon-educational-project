package educational.hackathon.roleplay_school;

import com.sun.net.httpserver.HttpServer;
import educational.hackathon.roleplay_school.connectors.SQLConnector;
import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.dao.DAOSession;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOAccountsSQL;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOSessionSQL;
import educational.hackathon.roleplay_school.dao.AllDAOs;
import educational.hackathon.roleplay_school.handlers.LoginPageHandler;
import educational.hackathon.roleplay_school.handlers.Static;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.httpHandlers.LoginHandler;
import educational.hackathon.roleplay_school.httpHandlers.student.StudentLeaderboard;
import educational.hackathon.roleplay_school.httpHandlers.student.StudentProfile;
import educational.hackathon.roleplay_school.httpHandlers.student.StudentQuests;
import educational.hackathon.roleplay_school.httpHandlers.teacher.TeacherAddQuest;
import educational.hackathon.roleplay_school.httpHandlers.teacher.TeacherLeaderboard;
import educational.hackathon.roleplay_school.httpHandlers.teacher.TeacherProfile;

import java.net.InetSocketAddress;
import java.sql.Connection;

public class Server {
    private AllDAOs allDAOs;

    public Server(AllDAOs allDAOs){
        this.allDAOs = allDAOs;
    }

    public void run() {
        try {
            CookieHelper cookieHelper = new CookieHelper("cookie");
            Connection connection = SQLConnector.getConnection();
            DAOAccounts daoAccounts = new DAOAccountsSQL(connection);
            DAOSession daoSession = new DAOSessionSQL(connection);
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
            httpServer.createContext("/", new LoginHandler(daoAccounts, daoSession, cookieHelper));
            httpServer.createContext("/studentProfile", new StudentProfile(allDAOs, new CookieHelper("")));
            httpServer.createContext("/studentQuests", new StudentQuests(allDAOs, new CookieHelper("")));
            httpServer.createContext("/studentLeaderboard", new StudentLeaderboard(allDAOs, new CookieHelper("")));

            httpServer.createContext("/teacherProfile", new TeacherProfile(allDAOs, new CookieHelper("")));
            httpServer.createContext("/teacherAddQuest", new TeacherAddQuest(allDAOs, new CookieHelper("")));
            httpServer.createContext("/teacherLeaderboard", new TeacherLeaderboard(allDAOs, new CookieHelper("")));

            httpServer.createContext("/static", new Static());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (Exception e) {
            System.out.println("Can not run server:");
            System.out.println(e.getMessage());
        }
    }
}
