

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Verify_User extends HttpServlet {
    Connection con;
      PreparedStatement ps;
      public void init(){
          try{
              con=mypkg.Dbase.connect();
              String qr="SELECT username FROM `Buyer` WHERE username=? AND Password=?";
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
        PrintWriter out=response.getWriter();
        String buyerSession;String buyerS;
       
        String s1=request.getParameter("username");
        String s2=request.getParameter("Password");
        String s3=request.getParameter("utype");
        out.println(s3);
        if(s3.equalsIgnoreCase("Admin")){
            if(s1.equals("admin") && s2.equals("minimed")){
                response.sendRedirect("admin.jsp");
            }
            else{
                out.println("Invalid admin");
                out.println("<a href=Login.jsp>Try Again</a>");
            }
        }
            try{
                ps.setString(1,s1);
                ps.setString(2,s2);
                //HttpSession session = request.getSession();
                ResultSet rs=ps.executeQuery();
                boolean b=rs.next();
                if(b){
                    response.sendRedirect("Priscription.jsp");
                }
                else{
                    out.println("Invalid User");
                    out.println("<a href=index.jsp>Try Again</a>");
                }
                
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
