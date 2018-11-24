package educational.hackathon.roleplay_school.models;

public class Teacher extends User {
    private int teacherId;
    public Teacher(int idAccount, int teacherId, String username, String passwordHash, String name, String surname, String email, int role) {
        super(idAccount, username, passwordHash, name, surname, email, role);
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
