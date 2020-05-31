/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import models.Initiator;
import org.hibernate.Session;
import util.HibernateUtil;

public class InitiatorDAOImpl implements InitiatorDAO {

    @Override
    public Collection getAllInitiators() throws SQLException {

        Session session = null;
        List<String> initiators = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            initiators = session.createCriteria(Initiator.class).list();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return initiators;
    }
}
