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
import java.net.HttpCookie;
import java.sql.SQLException;
import java.util.Optional;

public class StudentProfile implements HttpHandler {
    private AllDAOs allDAOs;
    private CookieHelper cookieHelper;

    public StudentProfile(AllDAOs allDAOs, CookieHelper cookieHelper){
        this.allDAOs = allDAOs;
        this.cookieHelper = cookieHelper;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();

        if (method.equals("GET")){
//
            Optional<HttpCookie> cookie = cookieHelper.getSessionIdCookie(httpExchange);
            String sessionId = cookie.get().getValue();
            sessionId = sessionId.replace("\"", "");
            try {
                if (allDAOs.getDAOAccounts().isValidUserType(sessionId, "STUDENT")) {
                    createResponse(httpExchange, sessionId);
                } else {
                    System.out.println("Unauthorized request for student");
                    httpExchange.getResponseHeaders().add("Location", "/");
                    httpExchange.sendResponseHeaders(303, 0);

                }
                createResponse(httpExchange, sessionId);
            } catch (SQLException e){
                e.printStackTrace();
                httpExchange.getResponseHeaders().add("Location", "/");
                httpExchange.sendResponseHeaders(303, 0);
            }
        }
    }

    private void createResponse(HttpExchange httpExchange, String sessionId) throws IOException, SQLException{
        JtwigTemplate template = JtwigTemplate.classpathTemplate("template/student/profile.twig");
        JtwigModel model = JtwigModel.newModel();
        // TODO modify dao to request data based on sessionId
//        String nickname = appDAOs.getDAOAccounts().getAccountBySessionId(sessionId).getNickname();
        Account account = allDAOs.getDAOSession().getAccountBySessionID(sessionId);
//        Account account = new Account(1, "trzaskus", "qwerty", "Karol", "Trzaska", "k.trzas@ka.pl", "student");
        model.with("accountName", account.getName());
        model.with("accountSurname", account.getSurname());
        model.with("exp", account.getExp());
        model.with("level", account.getLevel());
        model.with("gold", account.getGold());
//        model.with("userNickname", nickname);
        String response = template.render(model);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
