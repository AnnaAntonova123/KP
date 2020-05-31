/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class PerformerDAOImpl implements PerformerDAO {

    @Override
    public List<Performer> getAllPerformers() throws SQLException {
        Session session = null;
        List<Performer> performers = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            performers = session.createCriteria(Performer.class).list();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return performers;
    }

    @Override
    public Performer getPerformerById(int id) throws SQLException {
        Session session = null;
        Performer performer = new Performer();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            performer = (Performer) session.get(Performer.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return performer;
    }
}
