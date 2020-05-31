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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Document;

/**
 *
 * @author admin
 */
public class editDocument extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("docid"));
            Document currentDoc = SessionFactory.getInstance().getDocumentDAO().getDocumentById(id);
            List<String> allTypes = (List<String>) SessionFactory.getInstance().getTypeDAO().getAllTypes();
            request.setAttribute("allTypes", allTypes);
            List<String> allStatuses = (List<String>) SessionFactory.getInstance().getStatusDAO().getAllStatuses();
            request.setAttribute("allStatuses", allStatuses);
            List<String> allPerformers = (List<String>) SessionFactory.getInstance().getPerformerDAO().getAllPerformers();
            request.setAttribute("allPerformers", allPerformers);
            List<String> allInitiators = (List<String>) SessionFactory.getInstance().getInitiatorDAO().getAllInitiators();
            request.setAttribute("allInitiators", allInitiators);
            
            if (currentDoc != null) {
                request.setAttribute("currentDoc", currentDoc);
                request.getRequestDispatcher("/editdocs.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(showAllDocs.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
