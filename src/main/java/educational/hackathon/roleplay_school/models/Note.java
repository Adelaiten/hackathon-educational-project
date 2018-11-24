package educational.hackathon.roleplay_school.models;


public class Note {
    private int noteId;
    private String note;
    private String date;
    private String author;



    public Note(int noteId, String note, String date, String author) {
        this.noteId = noteId;
        this.note = note;
        this.date = date;
        this.author = author;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String lastAuthor) {
        this.author = lastAuthor;
    }
}
