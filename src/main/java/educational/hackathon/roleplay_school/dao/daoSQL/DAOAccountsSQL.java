package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DAOAccountsSQL implements DAOAccounts {
    private Connection connection;

    public DAOAccountsSQL(Connection connection){
        this.connection = connection;
    }

    public Account getAccountByNickname(String nickname) throws SQLException, NoSuchElementException {
        return null;
    }


    public List<Account> readAllStudents() throws SQLException{
        String readAllStudentsQuery = "SELECT * FROM account WHERE role=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(readAllStudentsQuery);
        preparedStatement.setString(1, "STUDENT");
        List<Account> studentsList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int idAccount = resultSet.getInt("id_account");
            String username = resultSet.getString("username");
            String passwordHash = resultSet.getString("passwd_hash");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String role = resultSet.getString("role");
            Account account = new Account(idAccount, username, passwordHash, name, surname, email, role);
            studentsList.add(account);
        }
        return studentsList;
    }
    @Override
    public Account getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException, NoSuchElementException {
        String sql = "SELECT * FROM account WHERE username=? AND passwd_hash=? ;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nickname);
        ps.setString(2, password);
        System.out.println(ps.toString());
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            return extractAccountFromResult(resultSet);
        } else {
            throw new NoSuchElementException();
        }
    }

    public int getExpFromDatabase(int idAccount) throws SQLException{
        String sqlExpQuery = "SELECT exp FROM account WHERE id_account = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpQuery);
        preparedStatement.setInt(1, idAccount);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getInt("exp");
    }

    public void increaseExpInDatabase(int idAccount, int exp) throws SQLException{
        int expFromDatabase = getExpFromDatabase(idAccount);
        expFromDatabase += exp;
        String sqlIncreaseExpQuery = "UPDATE account SET exp = ? WHERE id_account = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlIncreaseExpQuery);
        preparedStatement.setInt(1, exp);
        preparedStatement.setInt(2, idAccount);
        preparedStatement.executeUpdate();
    }

    public int getStudentCoins(int idAccount) throws SQLException{
        String coinsQuery = "SELECT coins FROM account WHERE id_account = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(coinsQuery);
        preparedStatement.setInt(1, idAccount);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("coins");
    }

    public void increaseStudentCoins(int idAccount, int coinsToIncrease) throws SQLException{
        int coins = getStudentCoins(idAccount);
        coins += coinsToIncrease;
        String increaseCoinsQuery = "UPDATE account SET coins = ? WHERE id_account = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(increaseCoinsQuery);
        preparedStatement.setInt(1, coinsToIncrease);
        preparedStatement.setInt(2, idAccount);
        preparedStatement.executeUpdate();
    }

    public void subtractStudentCoins(int idAccount, int coinsToSubtract) throws SQLException {
        int coins = getStudentCoins(idAccount);
        coins -= coinsToSubtract;
        String subtractCoinsQuery = "UPDATE account SET coins = ? WHERE id_account = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(subtractCoinsQuery);
        preparedStatement.setInt(1, coins);
        preparedStatement.setInt(2, idAccount);
        preparedStatement.executeUpdate();
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

    @Override
    public Account getAccountBySessionId(String sessionId) throws SQLException {
        String sql = "SELECT * FROM account INNER JOIN sessions ON account.id_account = sessions.id_account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return extractAccountFromResult(resultSet);
        }
        throw new NoSuchElementException();
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

    @Override
    public boolean isValidUserType(String sessionId, String userType) throws SQLException{
        boolean isValid = false;
        Account account = getAccountBySessionId(sessionId);
        if(account.getRole().equals(userType)){
            isValid = true;
        }
        return isValid;
    }
}
