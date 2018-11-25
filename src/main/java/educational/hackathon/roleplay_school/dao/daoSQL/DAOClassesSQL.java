package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.connectors.SQLConnector;
import educational.hackathon.roleplay_school.dao.DAOClasses;
import educational.hackathon.roleplay_school.models.ClassRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DAOClassesSQL implements DAOClasses {
    private final String CLASS_TABLE_NAME = "class";
    private final String ID_COLUMN_NAME = "id_class";
    private final String NAME_COLUMN_NAME = "name";

    private Connection connection;

    public DAOClassesSQL(Connection connection){
        connection = connection;
    }

    @Override
    public ClassRoom getClassRoom(int id) throws SQLException, NoSuchElementException{
        String sql = String.format("SELECT * FROM %s WHERE %s=?;", CLASS_TABLE_NAME, ID_COLUMN_NAME);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return extractClassFromResultSet(resultSet);
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public List<ClassRoom> getAllClasses() throws SQLException {
        String sql = String.format("SELECT * FROM %s;", CLASS_TABLE_NAME);
        List<ClassRoom> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(extractClassFromResultSet(resultSet));
            }
        }

        return result;
    }

    private ClassRoom extractClassFromResultSet(ResultSet resultSet) throws SQLException {
        return new ClassRoom(
            resultSet.getString(NAME_COLUMN_NAME),
            resultSet.getInt(ID_COLUMN_NAME)
        );
    }
}
