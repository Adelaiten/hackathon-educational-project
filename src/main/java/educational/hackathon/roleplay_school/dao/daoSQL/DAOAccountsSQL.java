package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.connectors.SQLConnector;
import educational.hackathon.roleplay_school.dao.DAOAccounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAccountsSQL implements DAOAccounts {
    private Connection connection;
    public DAOAccountsSQL(Connection connection){
        this.connection = connection;
    }
    public void getAccountsByNicknameAndPassword(String nickname, String password) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE nick=? AND password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nickname);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            resultSet.
        }
    }


}
