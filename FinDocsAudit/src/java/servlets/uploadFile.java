/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.SessionFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Document;
import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadFile extends HttpServlet {
    
    private static final String SAVE_DIR = "data\\files";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //проверяем является ли полученный запрос multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Создаём класс фабрику 
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Максимальный буфера данных в байтах,
        // при его привышении данные начнут записываться на диск во временную директорию
        // устанавливаем один мегабайт
        factory.setSizeThreshold(1024 * 1024);

        // устанавливаем временную директорию
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        //Создаём сам загрузчик
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");

        //максимальный размер данных который разрешено загружать в байтах
        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт. 
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            String fileName = null;

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (item.isFormField()) {
                    //если принимаемая часть данных является полем формы			    	
                    processFormField(item);
                } else {
                    //в противном случае рассматриваем как файл
                    fileName = processUploadedFile(item);
                }
            }

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

            currentDoc.setFile(fileName);
            SessionFactory.getInstance().getDocumentDAO().updateDocument(id, currentDoc);

            if (currentDoc != null) {
                request.setAttribute("currentDoc", currentDoc);
                request.getRequestDispatcher("/editdocs.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/errordocs.jsp").forward(request, response);
            }

        } catch (Exception e) {
            Logger.getLogger(showAllDocs.class.getName()).log(Level.SEVERE, null, e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadedFile = null;

        String fileName = item.getName();
        String appPath = getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        String filePath = savePath + File.separator + fileName;
        uploadedFile = new File(filePath);

        uploadedFile.createNewFile();
        item.write(uploadedFile);

        return fileName;
    }

    private void processFormField(FileItem item) {
        System.out.println(item.getFieldName() + "=" + item.getString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
