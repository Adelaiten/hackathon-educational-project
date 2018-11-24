package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Account;

public interface DAOSession {
    public void setSessionId(String sessionId, int accountId);
}
