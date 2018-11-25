package educational.hackathon.roleplay_school.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<E> {
    E map(ResultSet resultSet) throws SQLException;
}
