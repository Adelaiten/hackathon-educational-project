package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.NotesDAOInterface;
import educational.hackathon.roleplay_school.models.Note;

import java.sql.*;
import java.util.Date;

public class NotesDAO implements NotesDAOInterface {
    private Connection connection;


    public NotesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Note getNoteFromDatabase(int idNote) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM notes WHERE id_account = ?;");
        preparedStatement.setInt(1, idNote);
        ResultSet resultSet = preparedStatement.executeQuery();
        Note note = null;
        while(resultSet.next()) {
            int noteId = resultSet.getInt("id_note");
            int accountId = resultSet.getInt("id_account");
            String noteText = resultSet.getString("note");
            note = new Note(noteId, noteText, accountId);
        }
        return note;
    }

    @Override
    public void updateNoteInDatabase(int noteId, String noteText) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("update note SET note = ? WHERE id_note = ?;");
        preparedStatement.setString(1, noteText);
        preparedStatement.setInt(1, noteId);
        preparedStatement.executeUpdate();

    }

    @Override
    public void insertNoteIntoDatabase(int noteId, int accountId, String note) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO note (id_note, id_account, note) VALUES (?, ?, ?);");
        preparedStatement.setInt(1, noteId);
        preparedStatement.setInt(2, accountId);
        preparedStatement.setString(3, note);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteNoteFromDatabase(int noteId) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("delete FROM note WHERE id_note = ?;");
        preparedStatement.setInt(1, noteId);
        preparedStatement.executeUpdate();
    }
}
