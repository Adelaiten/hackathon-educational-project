package educational.hackathon.roleplay_school.httpHandlers.teacher;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.dao.AllDAOs;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;

public class TeacherAddQuest implements HttpHandler {
    private AllDAOs allDAOs;
    private CookieHelper cookieHelper;

    public TeacherAddQuest(AllDAOs allDAOs, CookieHelper cookieHelper){
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
        JtwigTemplate template = JtwigTemplate.classpathTemplate("template/teacher/home.twig");
        JtwigModel model = JtwigModel.newModel();
        // TODO modify dao to request data based on sessionId
//        String nickname = appDAOs.getDAOAccounts().getAccountBySessionId(sessionId).getNickname();

//        model.with("userNickname", nickname);
        String response = template.render(model);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
