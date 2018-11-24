package educational.hackathon.roleplay_school.models;




public class Note {
    private int noteId;
    private int authorId;
    private String note;


    public Note(int noteId, String note, int authorId) {
        this.noteId = noteId;
        this.note = note;
        this.authorId = authorId;
    }


    public String getNote() {
        return note;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public int getAuthor() {
        return authorId;
    }

    public void setAuthor(int lastAuthor) {
        this.authorId = lastAuthor;
    }
}
