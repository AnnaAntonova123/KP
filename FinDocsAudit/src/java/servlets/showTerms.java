/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.SessionFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Document;

/**
 *
 * @author admin
 */
@WebServlet(name = "showTerms", urlPatterns = {"/showterms"})
public class showTerms extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Document> expiredDocuments = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getDocumentsExpired();
            request.setAttribute("expiredDocuments", expiredDocuments);
            List<Document> expiringNextDaysDocuments = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getDocumentsExpiringNextDays(10);
            request.setAttribute("expiringNextDaysDocuments", expiringNextDaysDocuments);
                    
                    request.getRequestDispatcher("/terms.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(showAllDocs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
