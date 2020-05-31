/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.Collection;
import models.Document;
import models.Performer;

/**
 *
 * @author admin
 */
public interface DocumentDAO {
    public void addDocument(Document doc) throws SQLException ;
    public void newDocument(String input_number, String reg_date, String name,
            String type_id, String initiator_id, String status_id, String deadline,
            String performer_id, String description) throws SQLException ;
    public void updateDocument(int id, Document doc) throws SQLException;
    public void updateDocument(int id, String input_number, String reg_date, String name, 
            String type_id, String initiator_id, String status_id, String deadline, String performer_id,  
            String file, String description);
    public Document getLastDocument() throws SQLException;
    public Document getDocumentById(int id) throws SQLException;
    public void deleteDocumentById(int id) throws SQLException;
    public Collection getDocumentsByPerformer(int performer_id) throws SQLException;
    public Collection getAllDocuments() throws SQLException;
    public Collection getDocumentsExpiringNextDays(int days) throws SQLException;
    public Collection getDocumentsExpired() throws SQLException;
    public Collection getDocumentsStatistics() throws SQLException;
    public Collection getDocumentsByType(int id) throws SQLException;
    public Collection getDocumentsByInitiator(int id) throws SQLException;
    public Collection getDocumentsByStatus(int id) throws SQLException;
}
