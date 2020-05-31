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
//import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Document;

/**
 *
 * @author admin
 */
public class updateDocument extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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

            String input_number = request.getParameter("input_number");
            String reg_date = request.getParameter("reg_date");
            String name = request.getParameter("name");
            String type_id = request.getParameter("type");
            String initiator_id = request.getParameter("initiator");
            String status_id = request.getParameter("status");
            String deadline = request.getParameter("deadline");
            String performer_id = request.getParameter("performer");
            String file = request.getParameter("file");
            String desc = request.getParameter("description");

            SessionFactory.getInstance().getDocumentDAO().updateDocument(id, input_number, reg_date, name,
                    type_id, initiator_id, status_id, deadline, performer_id, file, desc);

            if (currentDoc != null) {
                List<Document> allDocuments = null;
                allDocuments = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getAllDocuments();
                request.setAttribute("allDocuments", allDocuments);
                request.getRequestDispatcher("/alldocs.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(showAllDocs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
