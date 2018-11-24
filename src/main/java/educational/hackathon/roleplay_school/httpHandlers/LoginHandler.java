package educational.hackathon.roleplay_school.httpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOAccountsSQL;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.*;


public class LoginHandler implements HttpHandler {
    private DAOAccounts daoAccounts;
    private CookieHelper cookieHelper;

    public LoginHandler(DAOAccounts daoAccounts, CookieHelper cookieHelper) {
        this.daoAccounts = daoAccounts;
        this.cookieHelper = cookieHelper;
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

    private void handleGETRequest(HttpExchange httpExchange){
        //TODO: load login twig here
    }

    private  void handlePOSTRequest(HttpExchange httpExchange) throws IOException {
        //TODO: GET ACCOUNT HASH ENTERED PASSWORD, CREATE COOKIE, REDIRECT
        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();
        System.out.println(formData);
        Map inputs = parseFormData(formData);
        String password = (String) inputs.get("password");
        String nick = (String) inputs.get("nick");
        System.out.println(nick + " " + password);
        try {
            Account account = daoAccounts.getAccountsByNicknameAndPassword(nick, password);
            String sessionId = UUID.randomUUID().toString();
            account.setSessionId(sessionId);
            //TODO: write sessionID to DB
            Optional<HttpCookie> cookie = Optional.of(new HttpCookie(cookieHelper.getSESSION_COOKIE_NAME(), sessionId));
            httpExchange.getResponseHeaders().add("Set-Cookie", cookie.get().toString());

            /**
             * TODO: refactor with using hashing
            if (account.getAccessLevel() == AccessLevel.ADMIN){
                httpExchange.getResponseHeaders().add("Location", "/admin/profile");
            } else if (account.getAccessLevel() == AccessLevel.MENTOR){
                httpExchange.getResponseHeaders().add("Location", "/mentor/profile");
            }*/


        } catch (NoSuchElementException e) {
            httpExchange.getResponseHeaders().add("Location", "/");
        } catch (SQLException e){
            //TODO: handle this shit
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
}
