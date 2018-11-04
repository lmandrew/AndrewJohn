//Delete.java

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
             String sqlquery= "delete from student where sid='"+stid+"'" ;
             rs= st.executeQuery(sqlquery);
             out.println("<center>Table after Deletion</center>");
             sqlquery= "select * from student ";
             rs= st.executeQuery(sqlquery);
             out.println("<html>" +"<head>" +"<title></title>" +"<link rel='stylesheet' href='style1.css'</head>" +"<body>");
             out.println("<form>");
             out.println("<div style='padding-left:650px;' id='disp'>");
	     out.println("<table border='1' cellspacing='0'");
	     out.println("<tr> <td><b> Name</b></td>");
	     out.println("<td><b>Student ID </b></td>");
	     out.println("<td><b>DOB</b></td>");
             out.println("<td><b>Gender</b></td>");	
	     out.println("<td><b>email</b></td>");
	     out.println("<td><b>phno</b></td>");
             out.println("<td><b>Address</b></td>");
	     out.println("</tr>");
           while(rs.next())
           {

out.println("<tr>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(6)+"</td>");
out.println("<td>"+rs.getString(7)+"</td>");
out.println("<td>"+rs.getString(8)+"</td>");
out.println("</tr>");
out.println("</div>");
out.println("</body>");
out.println("</form>");
 out.println("</html>");
           }
            }
        
        else
             {out.println("<p style="text-color:red;"><i>Invalid StudentId </i> </p>" )
              
             }
}
catch(Exception e){}
response.sendRedirect("Admindisp.html");
}
}
}
