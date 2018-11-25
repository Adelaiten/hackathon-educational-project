package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOSession;
import educational.hackathon.roleplay_school.helpers.CookieHelper;
import educational.hackathon.roleplay_school.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOSessionSQL implements DAOSession {
    private Connection connection;

    public DAOSessionSQL(Connection connection) {
        this.connection = connection;
    }

    public Account getAccountBySessionID(String sessionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select id_account FROM sessions WHERE session_id = ?;");
        preparedStatement.setString(1, sessionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = null;
        while(resultSet.next()) {
            PreparedStatement ps = connection.prepareStatement("select * FROM account WHERE id_account = ?");
            ps.setInt(1, resultSet.getInt("id_account"));
            ResultSet rSet = ps.executeQuery();
            while(rSet.next()) {
                int idAccount = rSet.getInt("id_account");
                String username = rSet.getString("username");
                String password = rSet.getString("passwd_hash");
                String name = rSet.getString("name");
                String surname = rSet.getString("surname");
                String email = rSet.getString("email");
                String role = rSet.getString("role");
                account = new Account(idAccount, username, password, name, surname, email, role);
            }
        }
        return account;
    }

    @Override
    public void setSessionId(String sessionId, int accountId) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("update sessions SET session_id = ? WHERE id_account = ?;");
        preparedStatement.setString(1, sessionId);
        preparedStatement.setInt(2, accountId);
        preparedStatement.executeUpdate();
    }
}
