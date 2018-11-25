package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Account;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public interface DAOAccounts {
    Account getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException, NoSuchElementException;
    void addAccountToDatabase(int idAccount, String username, String password, String salt, String name, String surname, String email, String role) throws SQLException;
    void updateAccountInDatabase(Account account) throws SQLException;
    void deleteAccountFromDatabase(int idAccount) throws SQLException;
    Account getAccountBySessionId(String sessionId) throws SQLException;
}
