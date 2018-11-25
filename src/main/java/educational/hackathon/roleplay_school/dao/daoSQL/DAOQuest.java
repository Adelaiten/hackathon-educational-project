package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOQuestInterface;
import educational.hackathon.roleplay_school.models.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOQuest implements DAOQuestInterface {
    private Connection connection;


    public DAOQuest(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Quest getQuestById(int id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM quest WHERE id_quest = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Quest quest = null;
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double amount = resultSet.getDouble("amount");
            int questType = resultSet.getInt("quest_type");
            quest = new Quest(id, name, description, 0, amount, questType);
        }

        return quest;
    }

    @Override
    public List<Quest> getAllStudentQuests(int accountsId) throws SQLException{
        List<Integer> studentIdQuests = getStudentQuestsIds(accountsId);
        List<Quest> questsList = new ArrayList<>();
        for(Integer questId : studentIdQuests) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * FROM quest WHERE id_quest = ?;");
            preparedStatement.setInt(1, questId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                int questType = resultSet.getInt("quest_type");
                Quest quest = new Quest(questId, name, description, 0, amount, questType);
                questsList.add(quest);
            }
        }
         return questsList;
    }

    private List<Integer> getStudentQuestsIds(int accountsId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_quest FROM done_quests WHERE id_student = ?;");
        preparedStatement.setInt(1, accountsId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> codecoolerIdQuests = new ArrayList<>();
        while(resultSet.next()) {
            Integer idQuest = resultSet.getInt("id_quest");
            codecoolerIdQuests.add(idQuest);
        }
        return codecoolerIdQuests;
    }
}
