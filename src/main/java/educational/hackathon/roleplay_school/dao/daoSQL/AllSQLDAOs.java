package educational.hackathon.roleplay_school.dao.daoSQL;

import educational.hackathon.roleplay_school.dao.*;
import educational.hackathon.roleplay_school.helpers.CookieHelper;

import java.sql.Connection;

public class AllSQLDAOs implements AllDAOs {
    private Connection connection;
    private CookieHelper cookieHelper;

    public AllSQLDAOs(Connection connection, CookieHelper cookieHelper){
        this.connection = connection;
        this.cookieHelper = cookieHelper;
    }

    @Override
    public DAOAccounts getDAOAccounts() {
        return new DAOAccountsSQL(connection);
    }

    @Override
    public DAOClasses getDAOClasses() {
        return new DAOClassesSQL(connection);
    }

    @Override
    public DAOQuestInterface getDAOQuest() {
        return new DAOQuest(connection);
    }

    @Override
    public DAOSession getDAOSession() {
        return new DAOSessionSQL(connection);
    }

    @Override
    public NotesDAO getDAONotes() {
        return new NotesDAO(connection);
    }
}
