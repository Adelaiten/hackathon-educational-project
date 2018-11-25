package educational.hackathon.roleplay_school.models;

public class Student extends Account {
    private int idClass;
    private int idStudent;

    public Student(int idAccount, int idStudent, String username, String passwordHash, String name, String surname, String email, String role, int idClass) {
        super(idAccount, username, passwordHash, name, surname, email, role);
        this.idClass = idClass;
        this.idStudent = idStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

}
