package educational.hackathon.roleplay_school.mappers;

import educational.hackathon.roleplay_school.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException{
        String username = resultSet.getString("username");
        String passwdHash = resultSet.getString("passwd_hash");
        String salt = resultSet.getString("salt");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String role = resultSet.getString("role");
        String email = resultSet.getString("email");

        return new User(username, passwdHash, salt, name, surname, role, email);
    }
}
