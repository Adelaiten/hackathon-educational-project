package educational.hackathon.roleplay_school.httpHandlers.student;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.dao.AllDAOs;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Quest;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentQuests implements HttpHandler {
    private AllDAOs allDAOs;
    private CookieHelper cookieHelper;

    public StudentQuests(AllDAOs allDAOs, CookieHelper cookieHelper){
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
        JtwigTemplate template = JtwigTemplate.classpathTemplate("template/student/quests.twig");
        JtwigModel model = JtwigModel.newModel();
        // TODO modify dao to request data based on sessionId
//        String nickname = appDAOs.getDAOAccounts().getAccountBySessionId(sessionId).getNickname();
        Quest quest1 = new Quest(1, "Do homework", "Very long description lorem ipsum non omnis moriar " +
                "hack yeah 2018 hackathooooon #nosleep", 20, 10.0, "");
        Quest quest2 = new Quest(2, "Make christmas decorations", "HOHOHO!", 10, 13.0, "");
        Quest quest3 = new Quest(3, "Just example", "Nice description here please!", 7, 7.0, "");
        Quest quest4 = new Quest(4, "Just example", "Nice description here please!", 7, 7.0, "");
        Quest quest5 = new Quest(5, "Just example", "Nice description here please!", 7, 7.0, "");
        List<Quest> quests = new ArrayList<>();
        quests.add(quest1);
        quests.add(quest2);
        quests.add(quest3);
        quests.add(quest4);
        quests.add(quest5);
        model.with("quests", quests);
//        model.with("userNickname", nickname);
        String response = template.render(model);
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
