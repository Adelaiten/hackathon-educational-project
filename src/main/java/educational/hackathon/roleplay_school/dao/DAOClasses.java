package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.ClassRoom;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public interface DAOClasses {
    public ClassRoom getClassRoom(int id) throws SQLException, NoSuchElementException;
    public List<ClassRoom> getAllClasses() throws SQLException;
}
