package educational.hackathon.roleplay_school.models;


import java.util.Date;

public class Note {
    private int noteId;
    private int authorId;
    private String note;
<<<<<<< HEAD


    public Note(int noteId, String note, int authorId) {
        this.noteId = noteId;
        this.note = note;
=======
    private String date;




    public Note(int noteId, String note, String date, int authoIdr) {
        this.noteId = noteId;
        this.note = note;
        this.date = date;
>>>>>>> Notedao
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

<<<<<<< HEAD
=======
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

>>>>>>> Notedao
    public int getAuthor() {
        return authorId;
    }

    public void setAuthor(int lastAuthor) {
        this.authorId = lastAuthor;
    }
}
