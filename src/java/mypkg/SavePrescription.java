
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;




public class SavePrescription extends HttpServlet  {  
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String Address="", Mobile="";
           byte imgdata[]=null;
           DiskFileItemFactory factory=new DiskFileItemFactory();
           ServletFileUpload upload=new ServletFileUpload(factory);
        try{
        List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
              for(FileItem item:items){
                  
            String name=item.getFieldName();
            out.println(name);
            if(name.equals("Address"))
            {
                Address=item.getString();
            }
            else if(name.equals("Mobile")){
           Mobile=item.getString();
            }
            else if(name.equals("img")){
                imgdata=item.get();
            }
    }
        }
        catch(Exception e){
            out.println(e);
        }
        
           java.util.Date dt=new java.util.Date();
          long ts=dt.getTime();
          java.sql.Date postDate=new java.sql.Date(ts);
          try{
          Connection con=mypkg.Dbase.connect();
          PreparedStatement ps=con.prepareStatement("select max(imgid) from Image1");
          ResultSet rs=ps.executeQuery();
          rs.next();
          int lastId=rs.getInt(1);
          int newId=5001;
          if(lastId!=0){
              newId=lastId+1;
          }
          PreparedStatement ps1=con.prepareStatement("insert into Image1 values(?,?,?,?,?)");      
          ps1.setBytes(1, imgdata);
          ps1.setDate(2, postDate);
          ps1.setInt(3, newId);
          ps1.setString(4, Address);
          ps1.setString(5,Mobile);
          ps1.executeUpdate();
          out.println("<html>");
          out.println("<body>");
          out.println("<h3>Your Prescription Has Uploded</h3>");
          out.println("<p>We will contact you whithin 24hrs for further details of your medicine<p>");
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SavePrescription.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SavePrescription.class.getName()).log(Level.SEVERE, null, ex);
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
