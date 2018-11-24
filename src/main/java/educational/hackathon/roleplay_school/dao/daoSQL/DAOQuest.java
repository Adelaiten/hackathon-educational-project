package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.DAOQuestInterface;
import educational.hackathon.roleplay_school.models.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOQuest implements DAOQuestInterface {
    private Connection connection;


    public DAOQuest(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Quest getQuestById(int id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * FROM quest WHERE id_quest = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Quest quest = null;
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            double amount = resultSet.getDouble("amount");
            int questType = resultSet.getInt("quest_type");
            quest = new Quest(id, name, description, amount, questType);
        }

        return quest;
    }

    @Override
    public List<Quest> getAllAccountsQuests(int accountsId) {
        return null;
    }
}
