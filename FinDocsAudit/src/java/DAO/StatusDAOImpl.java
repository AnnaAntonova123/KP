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
import models.Status;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class StatusDAOImpl implements StatusDAO {

    @Override
    public Collection getAllStatuses() throws SQLException {
        Session session = null;
        List<String> statuses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            statuses = session.createCriteria(Status.class).list();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return statuses;
    }

}
