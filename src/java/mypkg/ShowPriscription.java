
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowPriscription extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
         String id=request.getParameter("id");
        try{
            Connection con=Dbase.connect();
            String qr="select*from Image1";
            PreparedStatement ps=con.prepareStatement(qr);
              ps.setInt(1,Integer.parseInt(id));
            ResultSet rs=ps.executeQuery();
        out.println("<html>");
         out.println("<body>");
         out.println("<table broder=2");
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            out.println("<tr>");
            out.println("<tr>");
            out.println("<td>Prescription</td>");
           out.println("<td> <img width=800 height=500 src=\"ViewPrescription?id=5001\"></td>");
            out.println("</tr>");
             out.println("<tr>");
              out.println("<td>Date</td>");
               out.println("<td>"+s1+"</td>");
               out.println("</tr>");
               out.println("<tr>");
                out.println("<td>id</td>");
                out.println("<td>"+s2+"</td>");
                     out.println("</tr>");
                     out.println("</tr>");
          
        }
             out.println("</table>");
             out.println("</body>");
              out.println("</html>");
        }
        catch(Exception e){
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
