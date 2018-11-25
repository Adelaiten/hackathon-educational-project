package educational.hackathon.roleplay_school;

import educational.hackathon.roleplay_school.connectors.SQLConnector;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOClassesSQL;
import educational.hackathon.roleplay_school.dao.daoSQL.DAOQuest;
import educational.hackathon.roleplay_school.models.ClassRoom;
import educational.hackathon.roleplay_school.models.Quest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = SQLConnector.getConnection();
        DAOQuest daoQuest = new DAOQuest(connection);
        List<Quest> daoQuestList = daoQuest.getAllStudentQuests(1);
        for(Quest classRoom : daoQuestList) {
            System.out.println(classRoom.getName() + " " + classRoom.getAmount() + " " + classRoom.getAmount() + " " + classRoom.getQuestType() );

        }
    }
}
