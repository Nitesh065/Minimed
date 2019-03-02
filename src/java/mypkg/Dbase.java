
package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbase {
      public static Connection connect(){
          Connection con=null;
          try{
              Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Medicine", "root", "");
                System.out.println("Connected");
          }
          catch(Exception e){
              e.printStackTrace();
          }
          return con;
      }
          public static void main(String ars[]){
          Connection con=connect();
          System.out.println(con);
          System.out.println("Connected");
      }
    
    
}
