package educational.hackathon.roleplay_school.models;

import java.time.LocalDateTime;

public class Session {
    String session_id;
    LocalDateTime date;
    int account_id;

    public Session(String session_id, LocalDateTime date, int account_id) {
        this.session_id = session_id;
        this.date = date;
        this.account_id = account_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
