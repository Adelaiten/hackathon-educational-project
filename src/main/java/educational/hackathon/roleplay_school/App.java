package educational.hackathon.roleplay_school;

import educational.hackathon.roleplay_school.connectors.SQLConnector;
import educational.hackathon.roleplay_school.dao.daoSQL.AllSQLDAOs;
import educational.hackathon.roleplay_school.helpers.CookieHelper;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection connection = SQLConnector.getConnection();
        CookieHelper cookieHelper = new CookieHelper("session");
        AllSQLDAOs allSQLDAOs = new AllSQLDAOs(connection, cookieHelper);
        Server srv = new Server(allSQLDAOs);
        System.out.println("Starting app");
        srv.run();
        System.out.println("app started");


    }
}
