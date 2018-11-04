//Validates Admin Credentials and forwards the request to admindisp.html
//if not goes back to admin login page


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Adminpo extends HttpServlet {

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="c:\\ajay\\desktop\\pro\\database.accdb";
        String urll="jdbc:ucanaccess://"+path;
        Connection con = DriverManager.getConnection(urll);
           Statement st = con.createStatement();
            String name1=request.getParameter("adminId");
            String pass1=request.getParameter("password");
           PreparedStatement p = con.prepareStatement("select adminid,pass from admin where name=? and pass=?");
            p.setString(1,name1);
            p.setString(2, pass1);
            
            
            ResultSet rs = p.executeQuery();
            boolean temp=rs.next();
            RequestDispatcher rd;
                       
// rd.forward(request,response);
       
            if(temp)
            {
             rd = request.getRequestDispatcher("Admindisp.html");
             rd.forward(request,response);
             }
             else
             { rd = request.getRequestDispatcher("admin.html");
               rd.forward(request,response);
              }
                     
        out.close();
        }
        
        
        catch(Exception e){
            System.err.println(e);
        }
    }



}
