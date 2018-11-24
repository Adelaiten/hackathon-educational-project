package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.models.Quest;

import java.util.List;

public interface DAOQuestInterface {
    Quest getQuestById(int id);
    List<Quest> getAllAccountsQuests(int accountsId);
}
