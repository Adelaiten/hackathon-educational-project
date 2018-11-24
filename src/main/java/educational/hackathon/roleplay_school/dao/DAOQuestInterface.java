package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Quest;

import java.sql.SQLException;
import java.util.List;

public interface DAOQuestInterface {
    Quest getQuestById(int id) throws SQLException;
    List<Quest> getAllStudentQuests(int accountsId) throws SQLException;
}
