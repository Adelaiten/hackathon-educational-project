package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Note;

public interface NotesDAOInterface {
    Note getNoteFromDatabase(int authorId);
    void updateNoteInDatabase(int noteId);
    void insertNoteIntoDatabase();
    void deleteNoteFromDatabase(int noteId);
}
