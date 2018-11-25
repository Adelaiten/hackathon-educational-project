package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public interface DAOAccounts {
    public List<Account> readAllStudents() throws SQLException;
    Account getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException, NoSuchElementException;
    void addAccountToDatabase(int idAccount, String username, String password, String salt, String name, String surname, String email, String role) throws SQLException;
    void updateAccountInDatabase(Account account) throws SQLException;
    void deleteAccountFromDatabase(int idAccount) throws SQLException;
    Account getAccountBySessionId(String sessionId) throws SQLException;
    public boolean isValidUserType(String sessionId, String userType) throws SQLException;
}
