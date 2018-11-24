package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.NotesDAOInterface;
import educational.hackathon.roleplay_school.models.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotesDAO implements NotesDAOInterface {
    private Connection connection;


    public NotesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Note getNoteFromDatabase(int authorId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM notes WHERE author_id = ?");
        preparedStatement.setInt(1, authorId);
        return null;
    }

    @Override
    public void updateNoteInDatabase(int noteId) {

    }

    @Override
    public void insertNoteIntoDatabase() {

    }

    @Override
    public void deleteNoteFromDatabase(int noteId) {

    }
}
