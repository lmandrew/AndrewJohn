//Search.java

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        String path="c:\\ajay\\desktop\\pro\\database.accdb";
        String urll="jdbc:ucanaccess://"+path;
        String stid=request.getParameter("sid");
        Connection con = DriverManager.getConnection(urll);
        Statement st = con.createStatement();
        PreparedStatement p = con.prepareStatement("select sid from student where sid=? ");
        p.setString(1,stid);
        ResultSet rs = p.executeQuery();
        boolean temp=rs.next();
            if(temp)
            {
             String sqlquery= "select * from student where sid='"+stid+"'" ;
             rs= st.executeQuery(sqlquery);

           if(rs.next())
                   {
out.println("<html>" +"<head>" +"<title></title>" +"<link rel='stylesheet' href='style1.css' </head>" +"<body>");
out.println("<form action='Admindisp'>");
out.println("<div style='padding-left:500px;' id='disp'>");
out.println("<img src='person.png' height='200' width='200' style='padding-top: 25px;'>"+"<br><br>");
out.println("Student ID:       "+rs.getString(5)+"<br><br>");
out.println("Name:      "+rs.getString(4)+"<br><br>");
out.println("DOB:      "+rs.getString(7)+"<br><br>");
out.println("Gender:        "+rs.getString(2)+"<br><br>");
out.println("Email Id:        "+rs.getString(6)+"<br><br>");
out.println("Phone Number:      "+rs.getString(3)+"<br><br>");
out.println("Address:       "+rs.getString(8)+"<br><br>");
out.println("       <input type='submit' value ='close'");
out.println("</div>");
out.println("</body>");
out.println("</form>");
 out.println("</html>");
                    }
           
               }
            else{out.println("<p style="text-color:red;"><i>Invalid StudentId </i> </p>" )
              response.sendRedirect("Admindisp.html");}

           }
          catch(Exception e)  {}
              
            
        
    }

  
}
