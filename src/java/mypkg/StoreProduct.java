
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StoreProduct extends HttpServlet {
     Connection con;
      PreparedStatement ps;
      public void init(){
          try{
              con=mypkg.Dbase.connect();
              String qr="INSERT into BuyProduct Values(?,?,?)";
              ps=con.prepareStatement(qr);
          }
          catch(Exception e){
          }
          
      }
      public void destroy(){
          try{
              con.close();
          }
          catch(Exception e){
              
          }
      }

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
     
        String address = request.getParameter("Address");
        String quantity = request.getParameter("Quantity");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("Pro_id");
        
        try
        {
            ps.setString(1, address);
            ps.setString(2, quantity);
            ps.setString(3, id);
            ps.executeUpdate();
            out.println("YOUR PRODUCT WILL BE DELIVERED SOON");
        }catch(Exception e){
            //out.println(e);
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
