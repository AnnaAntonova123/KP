/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author admin
 */
public class SessionFactory {

    private static DocumentDAO documentDAO = null;
    private static TypeDAO typeDAO = null;
    private static StatusDAO statusDAO = null;
    private static PerformerDAO performerDAO = null;
    private static InitiatorDAO initiatorDAO = null;
    private static SessionFactory instance = null;

    public static synchronized SessionFactory getInstance() {
        if (instance == null) {
            instance = new SessionFactory();
        }
        return instance;
    }

    public DocumentDAO getDocumentDAO() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAOImpl();
        }
        return documentDAO;
    }

    public TypeDAO getTypeDAO() {
        if (typeDAO == null) {
            typeDAO = new TypeDAOImpl();
        }
        return typeDAO;
    }

    public StatusDAO getStatusDAO() {
        if (statusDAO == null) {
            statusDAO = new StatusDAOImpl();
        }
        return statusDAO;
    }

    public PerformerDAO getPerformerDAO() {
        if (performerDAO == null) {
            performerDAO = new PerformerDAOImpl();
        }
        return performerDAO;
    }

    public InitiatorDAO getInitiatorDAO() {
        if (initiatorDAO == null) {
            initiatorDAO = new InitiatorDAOImpl();
        }
        return initiatorDAO;
    }

}
