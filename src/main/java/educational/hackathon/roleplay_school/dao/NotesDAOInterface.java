package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Note;

import java.sql.SQLException;

public interface NotesDAOInterface {
    Note getNoteFromDatabase(int authorId) throws SQLException;
    void updateNoteInDatabase(int noteId);
    void insertNoteIntoDatabase();
    void deleteNoteFromDatabase(int noteId);
}
