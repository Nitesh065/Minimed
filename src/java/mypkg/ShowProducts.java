
package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowProducts extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
      try {
            Connection con = Dbase.connect();
            HttpSession session=request.getSession();
            String qr ="select*from Collection WHERE Product_name=?";
            String s=request.getParameter("Product_name");
            PreparedStatement ps = con.prepareStatement(qr);
            ps.setString(1,s);
            ResultSet rs = ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<table cloro=black broder=2 width=2 cellpadding=2 cellspacing 2>");
            rs.next(); 
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                String s7 = rs.getString(7);
                session.setAttribute("Pro_id",s1);
                out.println("<tr>");
                out.println("<tr>");    
                //out.println("<td></td>");
                out.println("<td> <img width=300 height=250 src=\"ViewProducts?Product_name=" + s2 + "\"></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Product_id</th>");
                out.println("<td>" + s1 + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Product_name</th>");
                out.println("<td>" + s2 + "</td>");
                out.println("</tr>");
                out.println("<th>Product_description</th>");
                out.println("<td><p>" + s3 + "</p></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Product_Category</td>");
                out.println("<td>" + s5+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Price</td>");
                out.println("<td>" + s6+ "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Quantity</td>");
                out.println("<td>" + s7+ "</td>");
                out.println("</tr>");
                out.println("</tr>");
                out.println("</tr>");
                
            
            out.println("</table>");
            //out.println("<p>"+s3+"</p>");
            out.println("<a href=Login1.jsp>BUY PRODUCT<a>");
            out.println("<a href=Logout>Logout<a>");
            out.println("</body>");
            out.println("</html>");
            }      
         catch (Exception e) {
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
