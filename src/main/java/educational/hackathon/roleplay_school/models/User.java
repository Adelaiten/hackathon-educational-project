package educational.hackathon.roleplay_school.models;

public class User {
    private String username;
    private String passwdHash;
    private String salt;
    private String name;
    private String surname;
    private String role;
    private String email;

    public User(String username, String passwdHash, String salt, String name,
                String surname, String role, String email) {
        this.username = username;
        this.passwdHash = passwdHash;
        this.salt = salt;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
