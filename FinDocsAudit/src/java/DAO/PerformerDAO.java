/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.Collection;
import models.Performer;

/**
 *
 * @author admin
 */
public interface PerformerDAO {
    public Collection getAllPerformers() throws SQLException;
    public Performer getPerformerById(int id) throws SQLException;
}
