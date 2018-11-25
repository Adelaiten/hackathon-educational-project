package educational.hackathon.roleplay_school.dao;

import educational.hackathon.roleplay_school.dao.DAOAccounts;
import educational.hackathon.roleplay_school.dao.DAOClasses;
import educational.hackathon.roleplay_school.dao.DAOQuestInterface;
import educational.hackathon.roleplay_school.dao.DAOSession;
import educational.hackathon.roleplay_school.dao.daoSQL.NotesDAO;

public interface AllDAOs {
    public DAOAccounts getDAOAccounts();
    public DAOClasses getDAOClasses();
    public DAOQuestInterface getDAOQuest();
    public DAOSession getDAOSession();
    public NotesDAO getDAONotes();
}
