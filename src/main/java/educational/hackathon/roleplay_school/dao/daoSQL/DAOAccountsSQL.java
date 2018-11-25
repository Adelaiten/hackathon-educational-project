package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class DAOAccountsSQL implements DAOAccounts {
    private Connection connection;

    public DAOAccountsSQL(Connection connection){
        this.connection = connection;
    }

    @Override
    public Account getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException, NoSuchElementException {
        String sql = "SELECT * FROM accounts WHERE nick=? AND password=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nickname);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            return extractAccountFromResult(resultSet);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void addAccountToDatabase(int idAccount, String username, String password, String salt, String name, String surname, String email, String role) throws SQLException{
        String sqlInsertAccount = "INSERT INTO account (id_account, username, passwd_hash, salt, name, surname, email, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertAccount);
        preparedStatement.setInt(1, idAccount);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, salt);
        preparedStatement.setString(5, name);
        preparedStatement.setString(6, surname);
        preparedStatement.setString(7, email);
        preparedStatement.setString(8, role);
        preparedStatement.executeUpdate();
    }

    private Account extractAccountFromResult(ResultSet resultSet) throws SQLException{
        Account account = new Account();
        account.setIdAccount(resultSet.getInt("id_account"));
        account.setName(resultSet.getString("name"));
        account.setSurname(resultSet.getString("surname"));
        account.setUsername(resultSet.getString("username"));
        account.setEmail(resultSet.getString("email"));
        account.setPasswordHash(resultSet.getString("passwd_hash"));
        account.setSalt(resultSet.getString("salt"));
        account.setRole(resultSet.getString("role"));
        return account;
    }

}
