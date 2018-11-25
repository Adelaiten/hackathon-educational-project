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
        String sql = "SELECT * FROM account WHERE username=? AND passwd_hash=?;";
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
        fillStatement(idAccount, username, password, salt, name, surname, email, role, preparedStatement);
        preparedStatement.executeUpdate();
    }

    public void updateAccountInDatabase(Account account) throws SQLException{
        String updateAccountQuery = "update account SET id_account = ?, username = ?, passwd_hash = ?, salt = ?, name = ?, surname = ?, email = ?, role = ?;";
        int accountId = account.getIdAccount();
        String username = account.getUsername();
        String password = account.getPasswordHash();
        String salt = account.getSalt();
        String name = account.getName();
        String surname = account.getSurname();
        String email = account.getEmail();
        String role = account.getRole();
        PreparedStatement preparedStatement = connection.prepareStatement(updateAccountQuery);
        fillStatement(accountId, username, password, salt, name, surname, email, role, preparedStatement);
        preparedStatement.executeUpdate();

    }

    public void deleteAccountFromDatabase(int idAccount) throws SQLException {
        String deleteAccountQuery = "DELETE FROM account WHERE id_account = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteAccountQuery);
        preparedStatement.setInt(1, idAccount);
        preparedStatement.executeUpdate();
    }

    private void fillStatement(int accountId, String username, String password, String salt, String name, String surname, String email, String role, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, accountId);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, salt);
        preparedStatement.setString(5, name);
        preparedStatement.setString(6, surname);
        preparedStatement.setString(7, email);
        preparedStatement.setString(8, role);
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
