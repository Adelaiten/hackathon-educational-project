package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Note;

import java.sql.SQLException;

public interface NotesDAOInterface {
    Note getNoteFromDatabase(int idNote) throws SQLException;
    void updateNoteInDatabase(int noteId, String noteText) throws SQLException;
    void insertNoteIntoDatabase(int id_note, int id_account, String note) throws SQLException;
    void deleteNoteFromDatabase(int noteId) throws SQLException;
}
