/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
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
public class addDocument extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addDocument</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addDocument at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        request.setCharacterEncoding("UTF-8");
        try {
            List<String> allTypes = (List<String>) SessionFactory.getInstance().getTypeDAO().getAllTypes();
            request.setAttribute("allTypes", allTypes);
            List<String> allStatuses = (List<String>) SessionFactory.getInstance().getStatusDAO().getAllStatuses();
            request.setAttribute("allStatuses", allStatuses);
            List<String> allPerformers = (List<String>) SessionFactory.getInstance().getPerformerDAO().getAllPerformers();
            request.setAttribute("allPerformers", allPerformers);
            List<String> allInitiators = (List<String>) SessionFactory.getInstance().getInitiatorDAO().getAllInitiators();
            request.setAttribute("allInitiators", allInitiators);

            Document newDoc = new Document();
            request.setAttribute("newDoc", newDoc);
            request.getRequestDispatcher("/newdoc.jsp").forward(request, response);

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
        request.setCharacterEncoding("UTF-8");
        try {
            String input_number = request.getParameter("input_number");
            String reg_date = request.getParameter("reg_date");
            String name = request.getParameter("name");
            String type_id = request.getParameter("type");
            String initiator_id = request.getParameter("initiator");
            String status_id = request.getParameter("status");
            String deadline = request.getParameter("deadline");
            String performer_id = request.getParameter("performer");
            String desc = request.getParameter("desc");
            SessionFactory.getInstance().getDocumentDAO().newDocument(input_number, reg_date, name, type_id, initiator_id, status_id, deadline, performer_id, desc);

            List<Document> allDocuments = null;
            allDocuments = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getAllDocuments();
            request.setAttribute("allDocuments", allDocuments);
            request.getRequestDispatcher("/alldocs.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(addDocument.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
        }
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

}
