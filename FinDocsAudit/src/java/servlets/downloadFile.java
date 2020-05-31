/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.SessionFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class downloadFile extends HttpServlet {

    private static final String SAVE_DIR = "data\\files";

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int docid = Integer.parseInt(request.getParameter("docid"));
        String appPath = getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        String docFileName = null;
        try {
            docFileName = SessionFactory.getInstance().getDocumentDAO().getDocumentById(docid).getFile();
            //docFileName = URLEncoder.encode(docFileName,"UTF-8"); 
            String filePath = savePath + File.separator + docFileName;
            if (docFileName == null) {
                request.getRequestDispatcher("/errordownload.jsp").forward(request, response);
            } else {
                File downloadFile = new File(filePath);
                String fileName = URLEncoder.encode(downloadFile.getName(), "UTF-8");
                OutputStream outStream;

                try (FileInputStream inStream = new FileInputStream(downloadFile)) {

                    String relativePath = getServletContext().getRealPath("");
                    System.out.println("relativePath = " + relativePath);

                    ServletContext context = getServletContext();

                    String mimeType = context.getMimeType(filePath);
                    if (mimeType == null) {
                        mimeType = "application/octet-stream";
                    }

                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadFile.length());

                    response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

                    outStream = response.getOutputStream();

                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                }
                outStream.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(downloadFile.class.getName()).log(Level.SEVERE, null, ex);
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
