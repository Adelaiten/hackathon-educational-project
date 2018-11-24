package educational.hackathon.roleplay_school.models;

import java.util.List;

public class ClassRoom {
    private List<User> usersInClassList;
    private String classRoomName;
    private int classId;

    public ClassRoom(String classRoomName, int classId) {
        this.classRoomName = classRoomName;
        this.classId = classId;
    }

    public List<User> getUsersInClassList() {
        return usersInClassList;
    }

    public void setUsersInClassList(List<User> usersInClassList) {
        this.usersInClassList = usersInClassList;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
