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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Document;
import models.Performer;

/**
 *
 * @author admin
 */
@WebServlet(name = "performers", urlPatterns = {"/performers"})
public class performers extends HttpServlet {

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
            out.println("<title>Servlet performers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet performers at " + request.getContextPath() + "</h1>");
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
        try {
            int id = Integer.parseInt(request.getParameter("performerid"));

            if (id == 0) { // страница по умолчанию
                List<Performer> allPerformers = (List<Performer>) SessionFactory.getInstance().getPerformerDAO().getAllPerformers();
		request.setAttribute("allPerformers", allPerformers);
                request.getRequestDispatcher("/performers.jsp").forward(request, response);
            }
            if (id > 0) { // страница с выбранным исполнителем
                List<Performer> allPerformers = (List<Performer>) SessionFactory.getInstance().getPerformerDAO().getAllPerformers();
		request.setAttribute("allPerformers", allPerformers);
                
                Performer currentPerformer = (Performer) SessionFactory.getInstance().getPerformerDAO().getPerformerById(id);
                request.setAttribute("currentPerformer", currentPerformer);
                
                List<Document> performerDocs = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getDocumentsByPerformer(id);
		request.setAttribute("performerDocs", performerDocs);
                
                List<Document> performersStat = (List<Document>) SessionFactory.getInstance().getDocumentDAO().getDocumentsStatistics();
		request.setAttribute("performersStat", performersStat);

                request.getRequestDispatcher("/performers.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(performers.class.getName()).log(Level.SEVERE, null, ex);
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

}
