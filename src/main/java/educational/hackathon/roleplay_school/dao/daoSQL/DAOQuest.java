package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOQuestInterface;
import educational.hackathon.roleplay_school.models.Quest;
import sun.rmi.runtime.NewThreadAction;

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
            int questExp = resultSet.getInt("exp");
            quest = new Quest(id, name, description, questExp, amount, questType);
        }

        return quest;
    }

    public List<Quest> getAllQuestsFromDatabase() throws SQLException {
        List<Quest> allQuests = new ArrayList<>();
        String allCookiesQuery = "SELECT * FROM quest;";
        PreparedStatement preparedStatement = connection.prepareStatement(allCookiesQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int idQuest = resultSet.getInt("id_quest");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            int amount = resultSet.getInt("amount");
            String questType = resultSet.getString("quest_type");
            int exp = resultSet.getInt("exp");
            Quest quest = new Quest(idQuest, name, description, exp, amount, questType);
            allQuests.add(quest);
        }
        return allQuests;
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
                int exp = resultSet.getInt("exp");
                Quest quest = new Quest(questId, name, description, exp, amount, questType);
                questsList.add(quest);
            }
        }
         return questsList;
    }
    public void UpdateInDatabaseEditedQuest(Quest quest) throws SQLException{
        String updateQuestQuery = "UPDATE quest SET id_quest = ?, name = ?, description = ?, amount = ?, exp = ?, quest_type = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuestQuery);
        preparedStatement.executeUpdate();
    }

    public void addQuestToDatabase(String name, String description, int amount, int exp, String quest_type) throws SQLException {
        String addQuestQuery = "INSERT INTO quest (name, description, amount, exp, quest_type) VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addQuestQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.setInt(3, amount);
        preparedStatement.setInt(4, exp);
        preparedStatement.setString(5, quest_type);
        preparedStatement.executeUpdate(addQuestQuery);
    }

    public void deleteQuestFromDatabase(int idQuest) throws SQLException{
        String deleteQuestQuery = "DELETE FROM quest WHERE id_quest = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuestQuery);
        preparedStatement.setInt(1, idQuest);
        preparedStatement.executeUpdate();
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
