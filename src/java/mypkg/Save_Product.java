/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class Save_Product extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Product_id = "", Product_name = "", Product_Description = "", Product_Category = "", Product_price = "", Product_Quantity = "";
        byte imgdata[] = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
            for (FileItem item : items) {
                String name = item.getFieldName();
                if (name.equals("Product_id")) {
                    Product_id = item.getString();
                } else if (name.equals("Product_name")) {
                    Product_name= item.getString();
                } else if (name.equals("Product_description")) {
                    Product_Description = item.getString();
                } else if (name.equals("Product_Category")) {
                    Product_Category = item.getString();
                } else if (name.equals("Product_price")) {
                    Product_price = item.getString();
                } else if (name.equals("Quantity")) {
                    Product_Quantity = item.getString();
                      } else if (name.equals("image")) {
                    imgdata= item.get();
              
            }
            }
        }    
         catch (Exception e) {
            out.println(e);
        }
        try{
        Connection con=mypkg.Dbase.connect();
         PreparedStatement ps1=con.prepareStatement("insert into Collection values(?,?,?,?,?,?,?)");      
         ps1.setString(1,Product_id);
         ps1.setString(2,Product_name);
         ps1.setString(3,Product_Description);
          ps1.setBytes(4,imgdata);
         ps1.setString(5,Product_Category );
         ps1.setString(6,Product_price);
         ps1.setString(7,Product_Quantity);
         ps1.executeUpdate();
         out.println("<html>");
         out.println("<body>");
         out.println("<h3>Uploded</h3>");
         out.println("<body>");
         out.println("</html>");
          
         }
         catch(Exception e){
         out.println(e);
          
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
        processRequest(request, response);
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
