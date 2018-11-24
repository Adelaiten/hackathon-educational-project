package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOSession;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;

public class DAOSessionSQL implements DAOSession {
    private CookieHelper cookieHelper;

    public DAOSessionSQL(CookieHelper cookieHelper) {
        this.cookieHelper = cookieHelper;
    }

    public Account getAccountBySessionID(){
        return null;
    }

    @Override
    public void setSessionId(String sessionId, int accountId) {

    }
}
