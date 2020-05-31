/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Document;
import models.Initiator;
import models.Type;
import models.Performer;
import models.Status;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class DocumentDAOImpl implements DocumentDAO {

    @Override
    public void addDocument(Document doc) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(doc);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            DriverManager.println("Ошибка при вставке");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateDocument(int id, Document doc) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            String hql = "update fin_dept_docs.document set"
                    + " document.input_number = :input_number, "
                    + " document.reg_date = :reg_date, "
                    + " document.name = :name, "
                    + " document.type_id = :type_id, "
                    + " document.initiator_id = :initiator_id, "
                    + " document.status_id = :status_id, "
                    + " document.deadline = :deadline, "
                    + " document.performer_id = :performer_id, "
                    + " document.file = :file, "
                    + " document.description = :description "
                    + "WHERE id = :id";
            Query query = (Query) session.createSQLQuery(hql);
            query.setParameter("input_number", doc.getInputNumber());
            query.setParameter("reg_date", doc.getRegDate());
            query.setParameter("name", doc.getName());
            query.setParameter("type_id", doc.getType().getId());
            query.setParameter("initiator_id", doc.getInitiator().getId());
            query.setParameter("status_id", doc.getStatus().getId());
            query.setParameter("deadline", doc.getDeadline());
            query.setParameter("performer_id", doc.getPerformer().getId());
            query.setParameter("file", doc.getFile());
            query.setParameter("description", doc.getDescription());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            //DriverManager.println("Ошибка при вставке");
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateDocument(int id, String input_number, String reg_date, String name,
            String type_id, String initiator_id, String status_id, String deadline, String performer_id,
            String file, String description) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "update document set"
                    + " input_number = :input_number, "
                    + " reg_date = :reg_date, "
                    + " name = :name, "
                    + " type_id = :type_id, "
                    + " initiator_id = :initiator_id, "
                    + " status_id = :status_id, "
                    + " deadline = :deadline, "
                    + " performer_id = :performer_id, ";
            if (file != "") {
                hql += " file = :file, ";
            }

            hql += " description = :description "
                    + "WHERE id = :id";
            Query query = (Query) session.createSQLQuery(hql);
            query.setParameter("input_number", input_number);
            query.setParameter("reg_date", reg_date);
            query.setParameter("name", name);
            query.setParameter("type_id", type_id);
            query.setParameter("initiator_id", initiator_id);
            query.setParameter("status_id", status_id);
            query.setParameter("deadline", deadline);
            query.setParameter("performer_id", performer_id);
            if (file != "") {
                query.setParameter("file", file);
            }
            query.setParameter("description", description);
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            //DriverManager.println("Ошибка при вставке");
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getDocumentsByPerformer(int performer_id) throws SQLException {
        Session session = null;
        List documents = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String sql = "SELECT * FROM document WHERE performer_id = " + performer_id + " ORDER BY deadline ASC";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            documents = query.list();

        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Document getDocumentById(int id) throws SQLException {
        Session session = null;
        Document doc = new Document();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            doc = (Document) session.load(Document.class, id);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return doc;
    }

    @Override
    public Collection getAllDocuments() throws SQLException {
        Session session = null;
        List<Document> documents = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            documents = session.createCriteria(Document.class).list();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public void newDocument(String input_number, String reg_date, String name,
            String type_id, String initiator_id, String status_id, String deadline,
            String performer_id, String description) throws SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Document doc = new Document();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            doc.setInputNumber(input_number);

            Date regDate = format.parse(reg_date);
            doc.setRegDate(regDate);

            doc.setName(name);

            Type type = new Type();
            type.setId(Integer.parseInt(type_id));
            doc.setType(type);

            Initiator initiator = new Initiator();
            initiator.setId(Integer.parseInt(initiator_id));
            doc.setInitiator(initiator);

            Status status = new Status();
            status.setId(Integer.parseInt(status_id));
            doc.setStatus(status);

            Date deadlineDate = format.parse(deadline);
            doc.setDeadline(deadlineDate);

            Performer performer = new Performer();
            performer.setId(Integer.parseInt(performer_id));
            doc.setPerformer(performer);

            doc.setDescription(description);
            doc.setFile(null);

            session.save(doc);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw e;
        } catch (ParseException ex) {
            Logger.getLogger(DocumentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Document getLastDocument() throws SQLException {
        Session session = null;
        Document lastDoc = new Document();
        List<Document> documents = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            documents = session.createCriteria(Document.class).list();
            lastDoc = documents.get(documents.size() - 1);
        } catch (HibernateException e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lastDoc;
    }

    @Override
    public void deleteDocumentById(int id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(getDocumentById(id));
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getDocumentsExpiringNextDays(int days) throws SQLException {
        Session session = null;
        List documents = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String sql = "SELECT \n"
                    + "document.id, \n"
                    + "document.input_number, \n"
                    + "document.reg_date,\n"
                    + "document.`name`,\n"
                    + "performer.name AS performerName,\n"
                    + "initiator.name AS initiatorName,\n"
                    + "deadline,\n"
                    + "status.name AS statusName,\n"
                    + "DATEDIFF(deadline,CURDATE()) AS expDays"
                    + "\n"
                    + "FROM fin_dept_docs.document \n"
                    + "\n"
                    + "JOIN fin_dept_docs.initiator ON document.initiator_id = initiator.id\n"
                    + "JOIN fin_dept_docs.performer ON document.performer_id = performer.id\n"
                    + "JOIN fin_dept_docs.status ON document.status_id = status.id\n"
                    + "\n"
                    + "WHERE deadline >= curdate() AND DATEDIFF(deadline,CURDATE()) <=" + days + "\n"
                    + "\n"
                    + "ORDER BY deadline ASC";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            documents = query.list();

        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Collection getDocumentsExpired() throws SQLException {
        Session session = null;
        List documents = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String sql = "SELECT \n"
                    + "document.id, \n"
                    + "document.input_number, \n"
                    + "document.reg_date,\n"
                    + "document.`name`,\n"
                    + "performer.name AS performerName,\n"
                    + "initiator.name AS initiatorName,\n"
                    + "deadline,\n"
                    + "status.name AS statusName,\n"
                    + "DATEDIFF(CURDATE(), deadline) AS expDays"
                    + "\n"
                    + "FROM fin_dept_docs.document \n"
                    + "\n"
                    + "JOIN fin_dept_docs.initiator ON document.initiator_id = initiator.id\n"
                    + "JOIN fin_dept_docs.performer ON document.performer_id = performer.id\n"
                    + "JOIN fin_dept_docs.status ON document.status_id = status.id\n"
                    + "\n"
                    + "WHERE deadline < curdate() AND document.status_id = 2\n"
                    + "\n"
                    + "ORDER BY deadline ASC";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            documents = query.list();

        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Collection getDocumentsStatistics() throws SQLException {
        Session session = null;
        List documents = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String sql = "SELECT \n"
                    + "`document`.performer_id,\n"
                    + "`performer`.name AS performer,\n"
                    + "(\n"
                    + "    SELECT count(`document`.id)\n"
                    + "    FROM `fin_dept_docs`.document\n"
                    + "    WHERE `document`.status_id = 2 AND `performer`.id = `document`.performer_id\n"
                    + "    ) AS documents,\n"
                    + "(\n"
                    + "    SELECT count(`document`.id)\n"
                    + "    FROM `fin_dept_docs`.document\n"
                    + "    WHERE `document`.deadline < curdate() AND `document`.status_id = 2 AND `performer`.id = `document`.performer_id\n"
                    + "    ) AS exp\n"
                    + "    \n"
                    + "FROM `fin_dept_docs`.document\n"
                    + "JOIN `fin_dept_docs`.performer ON `performer`.id = `document`.performer_id\n"
                    + "\n"
                    + "group by performer\n"
                    + "order by `performer`.id";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

            documents = query.list();

        } catch (Exception e) {

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Collection getDocumentsByType(int id) throws SQLException {
        Session session = null;
        List<Document> tempDocuments = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tempDocuments = session.createCriteria(Document.class).list();
            if (!tempDocuments.isEmpty()) {
                for (int i = 0; i < tempDocuments.size(); i++) {
                    if (tempDocuments.get(i).getType().getId() == id) {
                        documents.add(tempDocuments.get(i));
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Collection getDocumentsByInitiator(int id) throws SQLException {
        Session session = null;
        List<Document> tempDocuments = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tempDocuments = session.createCriteria(Document.class).list();
            if (!tempDocuments.isEmpty()) {
                for (int i = 0; i < tempDocuments.size(); i++) {
                    if (tempDocuments.get(i).getInitiator().getId() == id) {
                        documents.add(tempDocuments.get(i));
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

    @Override
    public Collection getDocumentsByStatus(int id) throws SQLException {
        Session session = null;
        List<Document> tempDocuments = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tempDocuments = session.createCriteria(Document.class).list();
            if (!tempDocuments.isEmpty()) {
                for (int i = 0; i < tempDocuments.size(); i++) {
                    if (tempDocuments.get(i).getStatus().getId() == id) {
                        documents.add(tempDocuments.get(i));
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return documents;
    }

}
