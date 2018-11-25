package educational.hackathon.roleplay_school.httpHandlers.student;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.util.Optional;

public class StudentProfile implements HttpHandler {
    private CookieHelper cookieHelper;

    public StudentProfile(CookieHelper cookieHelper){
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
        JtwigTemplate template = JtwigTemplate.classpathTemplate("template/student/profile");
        JtwigModel model = JtwigModel.newModel();
        // TODO modify dao to request data based on sessionId
//        String nickname = appDAOs.getDAOAccounts().getAccountBySessionId(sessionId).getNickname();
//        model.with("userName", nickname);
//        model.with("userNickname", nickname);
        String response = template.render(model);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
