package educational.hackathon.roleplay_school.httpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.dao.DAOSession;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOAccountsSQL;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOSessionSQL;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;

import java.io.*;
import java.net.HttpCookie;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.*;


public class LoginHandler implements HttpHandler {
    private final String LOGIN_PAGE_URL = "static/index.html";
    private DAOAccounts daoAccounts;
    private CookieHelper cookieHelper;
    private DAOSession daoSession;

    public LoginHandler(DAOAccounts daoAccounts, DAOSession daoSession, CookieHelper cookieHelper) {
        this.daoAccounts = daoAccounts;
        this.cookieHelper = cookieHelper;
        this.daoSession = daoSession;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException{
        String method = httpExchange.getRequestMethod();
        if(method.equals("GET")){
            handleGETRequest(httpExchange);
        } else if(method.equals("POST")){
            handlePOSTRequest(httpExchange);
        }
    }

    private void handleGETRequest(HttpExchange httpExchange) throws IOException {
        StringBuilder result = new StringBuilder();
        String response = "";
        ClassLoader classLoader = getClass().getClassLoader();
        File loginPage = new File(classLoader.getResource(LOGIN_PAGE_URL).getFile());

        try (Scanner scanner = new Scanner(loginPage)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            response = result.toString();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(String.format("Couldn't read %s file", LOGIN_PAGE_URL));
        }
        sendResponse(httpExchange, response);
    }

    private  void handlePOSTRequest(HttpExchange httpExchange) throws IOException {
        //TODO: GET ACCOUNT HASH ENTERED PASSWORD, CREATE COOKIE, REDIRECT
        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();
        System.out.println(formData);
        Map inputs = parseFormData(formData);
        String password = (String) inputs.get("passwd_hash");
        String nick = (String) inputs.get("nick");
        System.out.println(nick + " " + password);
        try {
            Account account = daoAccounts.getAccountsByNicknameAndPassword(nick, password);
            String sessionId = UUID.randomUUID().toString();
            account.setSessionId(sessionId);
            daoSession.setSessionId(sessionId, account.getIdAccount()); //TODO implement this method
            Optional<HttpCookie> cookie = Optional.of(new HttpCookie(cookieHelper.getSESSION_COOKIE_NAME(), sessionId));
            httpExchange.getResponseHeaders().add("Set-Cookie", cookie.get().toString());


            if (account.getRole().equals("TEACHER")){
                httpExchange.getResponseHeaders().add("Location", "/teacher/profile");
            } else if (account.getRole().equals("STUDENT")){
                httpExchange.getResponseHeaders().add("Location", "/student/profile");
            } else {
                httpExchange.getResponseHeaders().add("Location", "/student/profile");
            }

        } catch (NoSuchElementException e) {
            httpExchange.getResponseHeaders().add("Location", "/");
            System.out.println("Coudn't find object in db");
        } catch (SQLException e){
            httpExchange.getResponseHeaders().add("Location", "/");
            System.out.println("wrong query");
        }
        httpExchange.sendResponseHeaders(303, 0);
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            // We have to decode the value because it's urlencoded. see: https://en.wikipedia.org/wiki/POST_(HTTP)#Use_for_submitting_web_forms
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }

    private void sendResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
