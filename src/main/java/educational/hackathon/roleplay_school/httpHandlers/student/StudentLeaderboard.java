package educational.hackathon.roleplay_school.httpHandlers.student;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.dao.AllDAOs;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentLeaderboard implements HttpHandler {
    private AllDAOs allDAOs;
    private CookieHelper cookieHelper;

    public StudentLeaderboard(AllDAOs allDAOs, CookieHelper cookieHelper){
        this.allDAOs = allDAOs;
        this.cookieHelper = cookieHelper;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();

        if (method.equals("GET")){
//            Optional<HttpCookie> cookie = cookieHelper.getSessionIdCookie(httpExchange);
//            String sessionId = cookie.get().getValue();
//            sessionId = sessionId.replace("\"", "");
//
//            if(appDAOs.getDAOAccounts().isValidUserType( sessionId, "ADMIN")) {
//                createResponse(httpExchange, sessionId);
//            } else {
//                System.out.println("Unauthorized request for admin");
//                httpExchange.getResponseHeaders().add("Location", "/");
//                httpExchange.sendResponseHeaders(303, 0);
//
//            }
            createResponse(httpExchange);
        }
    }

    private void createResponse(HttpExchange httpExchange) throws IOException{
        JtwigTemplate template = JtwigTemplate.classpathTemplate("template/student/leaderboard.twig");
        JtwigModel model = JtwigModel.newModel();
        // TODO modify dao to request data based on sessionId
//        String nickname = appDAOs.getDAOAccounts().getAccountBySessionId(sessionId).getNickname();
//        Account account1 = new Account(1, "trzaskus", "qwerty", "Karol", "Becla", "k.trzas@ka.pl", "STUDENT");
//        Account account2 = new Account(1, "radianos", "qwerty", "Adrian", "Trzaska", "a.trzas@ka.pl", "STUDENT");
//        Account account3 = new Account(1, "ferneddy", "qwerty", "Rafał", "Ostromęcki", "r.trzas@ka.pl", "STUDENT");
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = allDAOs.getDAOAccounts().readAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        accounts.add(account1);
//        accounts.add(account2);
//        accounts.add(account3);
        model.with("students", accounts);
//        model.with("userNickname", nickname);
        String response = template.render(model);
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
