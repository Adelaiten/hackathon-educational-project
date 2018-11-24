package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Account;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public interface DAOAccounts {
    public Account getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException, NoSuchElementException;
}
