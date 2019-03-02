
package mypkg;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class SavePrescription extends HttpServlet {
        Connection con;
    PreparedStatement ps;
     PreparedStatement ps1;
int newid=5001;      

    public void init() {
        try {
             
            con = mypkg.Dbase.connect();
            String qr = "insert into Image values(?,?,?)";
               ps = con.prepareStatement(qr);
              ps1=con.prepareStatement("selec max(imgid) from Image");
             ResultSet rs=ps1.executeQuery();
              rs.next();
              
              int lastid=rs.getInt(1);
              int newid=5001;
              if(lastid!=0){
                  newid=lastid+1;
              }
             
          
        } catch (Exception e) {
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {
        }
    }

    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
    
          String message=null;
        InputStream inputSterm=null;
        Part filePart=request.getPart("img");
        if(filePart!=null){
          inputSterm=filePart.getInputStream();
        }
          java.util.Date dt=new java.util.Date();
          long ts=dt.getTime();
          java.sql.Date postDate=new java.sql.Date(ts);
        try{
            if(inputSterm!=null){
                ps.setBlob(1, inputSterm);
                ps.setDate(2, postDate);
                ps.setInt(3, newid);
            
            }
            
            
            int row=ps.executeUpdate();
            if(row>0){
                message="File uploded into the database";
            }
        }
        catch(Exception e){
            message="ERROR" +e.getMessage();
        }
        
     
        
        request.setAttribute("Message", message);
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Message.jsp");
                dispatcher.forward(request, response);
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
